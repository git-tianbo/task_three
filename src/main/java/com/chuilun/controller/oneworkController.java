package com.chuilun.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.chuilun.pojo.onework;
import com.chuilun.service.oneworkService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/onework")
public class oneworkController {

    Logger logger = Logger.getLogger(oneworkController.class);

    @Resource
    oneworkService oneworkService;

    /**
     * @Author: TianBo
     * @Description: 主页面 / 重置
     * @Date: 2020/4/19
     * @return: java.util.Map
     **/

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map findAll() {

        Map<String, Object> map = new HashMap<>();

        try {
            List<onework> data = oneworkService.findAll();
            logger.info(data);

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

    /**
     * @Author: TianBo
     * @Description: 搜索
     * @Date: 2020/4/19
     * @Param oneworkName:
     * @Param state:
     * @return: java.util.Map
     **/

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Map search(@RequestParam(value = "oneworkName",required = false) String oneworkName, @RequestParam(value = "state",required = false) Integer state) {

        Map<String, Object> map = new HashMap<>();

        logger.info(oneworkName);
        logger.info(state);

        try {

            List<onework> data = oneworkService.search(oneworkName, state);
            logger.info(data);

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

    /**
     * @Author: TianBo
     * @Description: 根据姓名增加一个字段
     * @Date: 2020/4/19
     * @Param onework:
     * @return: java.util.Map
     **/

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map addName(onework onework) {
        Map<String, Object> map = new HashMap<>();
        logger.info(onework);

//      判断当前作品总数量是否为7  如果不为7则添加
        int count = oneworkService.countOne();

        if (count == 7) {
            map.put("code", 201);
            map.put("msg", "添加作品已达到上限");
            return map;
        } else {
            try {
               int result =  oneworkService.addName(onework);
                map.put("插入的id为", result);
                map.put("code", 200);
                map.put("msg", "添加成功");
                return map;
            } catch (Exception e) {
                map.put("code", 201);
                map.put("msg", "添加失败");
                return map;
            }
        }
    }

    /**
     * @Author: TianBo
     * @Description: 更改名称
     * @Date: 2020/4/19
     * @Param onework:
     * @return: java.util.Map
     **/

    @ResponseBody
    @RequestMapping(value = "/putName", method = RequestMethod.POST)
    public Map putName(onework onework) {

        Map<String, Object> map = new HashMap<>();

        logger.info("传入的数据为：" + onework);

        try {
            oneworkService.putName(onework);
            map.put("code", 200);
            map.put("msg", "更改成功");
            return map;

        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "更改失败");
            return map;
        }
    }


    /**
     * @Author: TianBo
     * @Description: 上下线
     * @Date: 2020/4/19
     * @Param oneId:
     * @return: java.util.Map
     **/

    @ResponseBody
    @RequestMapping(value = "/putState", method = RequestMethod.POST)
    public Map putState(Integer oneId) {

        Map<String, Object> map = new HashMap<>();
        logger.info("需要修改状态的id为：" + oneId);

        if (oneworkService.state(oneId) !=1) {
            oneworkService.onLine(oneId);
            map.put("code", 200);
            map.put("msg", "上线成功");
            return map;
        } else {
            oneworkService.offLine(oneId);
            map.put("code", 200);
            map.put("msg", "下线成功");
            return map;
        }
    }

    /**
     * @Author: TianBo
     * @Description: 删除
     * @Date: 2020/4/19
     * @Param oneId:
     * @return: java.util.Map
     **/


    @ResponseBody
    @RequestMapping(value = "/{oneId}", method = RequestMethod.DELETE)
    public Map deleteId(@PathVariable("oneId") Integer oneId) {
        Map<String, Object> map = new HashMap<>();

        logger.info(oneId);

        //二级有东西则 twoId threeId 里面有oneId 则不能删除

        if (oneworkService.state(oneId) == 1) {

            map.put("code", 201);
            map.put("msg", "当前为上线状态，不能删除");
            return map;
        } else {
            try {
                oneworkService.deleteId(oneId);
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




