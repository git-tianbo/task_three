package com.chuilun.controller;


import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.chuilun.pojo.banner;
import com.chuilun.service.bannerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class bannerController {

    Logger logger = Logger.getLogger(bannerController.class);

    @Resource
    bannerService bannerService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map findAll() {

        Map<String, Object> map = new HashMap<>();

        try {
            List<banner> data = bannerService.findAll();

            logger.info("输出参数为" + data);
            map.put("data", data);
            map.put("code", 200);
            map.put("msg", "进入主页面成功");
            return map;

        } catch (Exception e) {

            map.put("code", 201);
            map.put("msg", "进入主页面失败");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Map search(@RequestParam(value = "state",required = false) Integer state,
                      @RequestParam(value = "createBy",required = false) String createBy) {

        Map<String, Object> map = new HashMap<>();

        logger.info("传入参数状态为" + state + ",创建人为" + createBy);

        try {
            List<banner> data = bannerService.search(state, createBy);

            map.put("data", data);
            map.put("code", 200);
            map.put("msg", "查询成功");
            return map;

        } catch (Exception e) {

            map.put("code", 201);
            map.put("msg", "查询失败");
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map addBanner(banner banner) {

        Map<String, Object> map = new HashMap<>();

        logger.info("传入参数为" + banner);

        try {
            int id = bannerService.addBanner(banner);

            logger.info("自动生成的id为" + id);

            map.put("生成的id为：",id);
            map.put("code", 200);
            map.put("msg", "添加成功");
            return map;
        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "添加失败");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "putUrlAndPic", method = RequestMethod.POST)
    public Map putUrlAndPic(banner banner) {

        Map<String, Object> map = new HashMap<>();

        logger.info("传入的参数为" + banner);

        try {
            bannerService.putUrlAndPic(banner);
            map.put("code", 200);
            map.put("msg", "更改成功");
            return map;
        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "更改失败");
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/putState", method = RequestMethod.POST)
    public Map putState(Integer id) {

        Map<String, Object> map = new HashMap<>();

        logger.info("要修改状态的id为:" + id);

        if (bannerService.state(id) != 1) {
            try {
                bannerService.onLine(id);
                map.put("code", 200);
                map.put("msg", "上线成功");
                return map;
            } catch (Exception e) {
                map.put("code", 201);
                map.put("msg", "上线失败");
                return map;
            }
        } else {
            try {
                bannerService.offLine(id);
                map.put("code", 200);
                map.put("msg", "下线成功");
                return map;
            } catch (Exception e) {
                map.put("code", 201);
                map.put("msg", "下线失败");
                return map;
            }
        }
    }

    //    根据id删除
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map deleteId(@PathVariable("id") Integer id) {

        Map<String, Object> map = new HashMap<>();

        logger.info("输入的参数为："+id);

        if (bannerService.state(id) == 1) {
            map.put("code", 201);
            map.put("msg", "请先下线再进行删除操作！");
            return map;
        }else{
            try {
                bannerService.deleteId(id);
                map.put("code", 200);
                map.put("msg", "更改成功");
                return map;
            } catch (Exception e) {
                map.put("code", 201);
                map.put("msg", "更改失败");
                return map;
            }
        }
    }
}















