package com.chuilun.controller;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.chuilun.pojo.threework;
import com.chuilun.service.threeworkService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/threework")
public class threeworkController {

    Logger logger = Logger.getLogger(threeworkController.class);

    @Resource
    threeworkService threeworkService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map findAll() {

        Map<String, Object> map = new HashMap<>();

        try {
            List<threework> data = threeworkService.findAll();

            logger.info("查询结果为" + data);

            map.put("data", data);
            map.put("code", 200);
            map.put("msg", "进入主页面成功!");
            return map;

        } catch (Exception e) {

            map.put("code", 201);
            map.put("msg", "进入主页面失败!");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Map search(@RequestParam(value = "threeworkName",required = false) String threeworkName, @RequestParam(value = "state",required = false) Integer state) {

        Map<String, Object> map = new HashMap<>();

        logger.info("输入参数为threeworkName:" + threeworkName + "state:" + state);

        try {
            List<threework> data = threeworkService.search(threeworkName,state);

            logger.info("输出结果为：" + data);

            map.put("data", data);
            map.put("code", 200);
            map.put("msg", "搜索成功!");
            return map;

        } catch (Exception e) {

            map.put("code", 201);
            map.put("msg", "搜索失败，请重新输入搜索条件！");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map addThree(threework threework) {

        Map<String, Object> map = new HashMap<>();

        logger.info("输入参数为" + threework);

        try {
           int result = threeworkService.addThree(threework);
            map.put("返回的id为：",result);
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
    @RequestMapping(value = "/putThree", method = RequestMethod.POST)
    public Map putThree(threework threework) {

        Map<String, Object> map = new HashMap<>();

        logger.info("输入参数为" + threework);

        try {
            threeworkService.putThree(threework);

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
    public Map putState(Integer threeId) {

        Map<String, Object> map = new HashMap<>();

        logger.info("传入参数为" + threeId);

        //如果状态为上线状态（1）  下线
        if (threeworkService.state(threeId) != 1) {

            threeworkService.onLine(threeId);
            map.put("code", 200);
            map.put("msg", "下线成功");
            return map;
        } else {
            threeworkService.offLine(threeId);
            map.put("code", 201);
            map.put("msg", "上线成功");
            return map;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/{threeId}", method = RequestMethod.DELETE)
    public Map deleteId(@PathVariable Integer threeId) {

        Map<String, Object> map = new HashMap<>();

        logger.info("输出参数为" + threeId);

        if (threeworkService.state(threeId) == 1) {
            map.put("code", 200);
            map.put("msg", "请下线作品再进行删除");
            return map;
        } else {

            try {
                threeworkService.deleteId(threeId);
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