package com.chuilun.controller;


import com.chuilun.service.oneworkService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.chuilun.pojo.twowork;
import com.chuilun.service.twoworkService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/twowork")
public class twoworkController {

    Logger logger = Logger.getLogger(twoworkController.class);

    @Resource
    twoworkService twoworkService;

    //    查找全部
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map findAll() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<twowork> data = twoworkService.findAll();
            map.put("data", data);
            map.put("code", 200);
            map.put("msg", "进入主页面成功");
        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "进入主页面失败");
        }
        return map;
    }

    //    根据姓名/状态搜索
    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Map search(@RequestParam("twoworkName") String twoworkName, @RequestParam("state") Integer state) {

        Map<String, Object> map = new HashMap<>();

        logger.info("传入的参数为" + twoworkName + "和" + state);

        try {
            List<twowork> data = twoworkService.search(twoworkName, state);

            logger.info(data);

            map.put("data", data);
            map.put("code", 200);
            map.put("msg", "搜索成功");
        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "搜索失败");
        }
        return map;
    }

    //    添加新用户
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map addTwo(@RequestParam(value = "twoworkName",required = false) String twoworkName,@RequestParam(value = "oneworkName",required = false) String oneworkName) {

        logger.info("传入的参数为：twoworkName=" + twoworkName + ",oneworkName=" + oneworkName);

        Map<String, Object> map = new HashMap<>();

        try {
            int result = twoworkService.addTwo(twoworkName, oneworkName);
            map.put("生成的id为",result);
            map.put("code", 200);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "添加失败");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/putName", method = RequestMethod.POST)
    public Map upName(twowork twowork) {

        logger.info("传入的参数为：" + twowork);

        Map<String, Object> map = new HashMap<>();

        try {
            twoworkService.putName(twowork);
            map.put("code", 200);
            map.put("msg", "更改成功");
        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "更改失败");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/putState", method = RequestMethod.POST)
    public Map putState(Integer twoId) {

        logger.info("传入的参数twoId=" + twoId);

        Map<String, Object> map = new HashMap<>();
        //若当前状态为上架（1） 执行下架
        if (twoworkService.state(twoId) != 1) {
            try {
                twoworkService.onLine(twoId);
                map.put("code", 200);
                map.put("msg", "上线成功");
                return map;
            } catch (Exception e) {
                map.put("code", 201);
                map.put("msg", "上线失败");
                return map;
            }
            //若不为上架（1） 则执行上架
        } else {
            try {
                twoworkService.offLine(twoId);
                map.put("code", 200);
                map.put("msg", "下线成功");
                return map;
            } catch (Exception e) {
                map.put("code", 200);
                map.put("msg", "下线失败");
                return map;
            }
        }
    }
    @ResponseBody
    @RequestMapping(value = "/{twoId}", method = RequestMethod.DELETE)
    public Map deteleId(@PathVariable("twoId") Integer twoId) {

        logger.info("传入的参数为" + twoId);

        Map<String, Object> map = new HashMap<>();

//        判断当前状态state是否为上线状态
        if (twoworkService.state(twoId) == 1) {
            map.put("code", 201);
            map.put("msg", "请先下架作品集，再进行删除");
        } else {
            try {
                twoworkService.deleteId(twoId);
                map.put("code", 200);
                map.put("msg", "删除成功");
            } catch (Exception e) {
                map.put("code", 201);
                map.put("msg", "删除失败");
            }
        }
        return map;
    }
}




