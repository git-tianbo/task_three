package com.chuilun.controller;


import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.chuilun.pojo.studio;
import com.chuilun.service.studioService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/studio")
public class studioController {

    Logger logger = Logger.getLogger(twoworkController.class);

    @Resource
    studioService studioService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map findAll() {

        Map<String, Object> map = new HashMap<>();

        try {
            List<studio> data = studioService.findAll();

            map.put("data", data);

            logger.info("输出结果为" + data);
            map.put("code", 200);
            map.put("msg", "重置成功");
            return map;

        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "重置失败");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Map search(@RequestParam(value = "studioName",required = false) String studioName,
                      @RequestParam(value = "state",required = false) int state) {

        Map<String, Object> map = new HashMap<>();

        logger.info("传入的参数为" + studioName + "," + state);

        try {

            List<studio> data = studioService.search(studioName, state);

            logger.info("查询结果为" + data);

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
    public Map addStudio(studio studio) {

        Map<String, Object> map = new HashMap<>();

        logger.info("输入参数为" + studio);
        try {
           int result = studioService.addStudio(studio);

            map.put("生成的id为：",result);
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
    @RequestMapping(value = "/putStudio", method = RequestMethod.POST)
    public Map putStudio(studio studio) {

        Map<String, Object> map = new HashMap<>();

        logger.info("输入参数为" + studio);

        try {

            studioService.putStudio(studio);
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
    @RequestMapping(value = "/state", method = RequestMethod.POST)
    public Map putState(Integer id) {

        Map<String, Object> map = new HashMap<>();

        logger.info("输入参数为" + id);

//        若判定为上线状态，则下线   若判定为下线状态，则上线

        if (studioService.state(id) != 1) {
            try {
                studioService.onLine(id);
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
                studioService.offLine(id);
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

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map deleteId(@PathVariable("id") Integer id) {

        Map<String, Object> map = new HashMap<>();

        logger.info("输入参数为" + id);

        studioService.state(id);

        if (studioService.state(id)==1) {
            map.put("code", 201);
            map.put("msg", "请先下线再进行删除操作");
            return map;
        } else {
            try {
                studioService.deleteId(id);
                map.put("code", 200);
                map.put("msg", "删除成功");
                return map;

            } catch (Exception e) {
                map.put("code", 201);
                map.put("msg", "删除失败");
                return map;
            }
        }
    }
}





