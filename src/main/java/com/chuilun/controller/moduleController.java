package com.chuilun.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.chuilun.pojo.modules;
import com.chuilun.service.moduleService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    @Controller
    @RequestMapping("/modules")
    public class moduleController {

        Logger logger= Logger.getLogger(moduleController.class);

        @Resource
        moduleService moduleService;

        @ResponseBody
        @RequestMapping(method= RequestMethod.GET)
        public Map findAll(){

            Map<String,Object> map = new HashMap<>();

            try {
                List<modules> data = moduleService.findAll();

                logger.info("输出参数为："+data);

                map.put("data", data);
                map.put("code", 200);
                map.put("msg","进入主页面成功!");
                return map;

            }catch (Exception e) {

                map.put("code",201);
                map.put("msg","进入主页面失败!");
                return map;
            }
        }

        @ResponseBody
        @RequestMapping(value = "/search",method = RequestMethod.GET)
        public Map search(String moduleName){

            Map<String,Object> map = new HashMap<>();

          logger.info("传入参数为"+moduleName);

            try {
                List<modules> data = moduleService.search(moduleName);

                logger.info("输出参数为"+data);

                map.put("data", data);
                map.put("code", 200);
                map.put("msg","搜索成功!");
                return map;

            }catch (Exception e) {

                map.put("code",201);
                map.put("msg","未找到相关记录，请重新输入搜索条件！");
                return map;
            }
        }

        @ResponseBody
        @RequestMapping(method = RequestMethod.POST)
        public Map addModule(modules modules) {

            Map<String, Object> map = new HashMap<>();

            logger.info("输入参数为：" + modules);

            //判断传入参数的名字不为空
            if (modules.getModuleName() != null) {

                //判断模块名是否已存在
                if (moduleService.search(modules.getModuleName()) != null) {
                    map.put("code", 201);
                    map.put("msg", "模块名已存在，请重新输入");
                    return map;
                } else {
                    //判断prentID不为空
                    if (modules.getPrentID() != null) {
                        //添加
                        try {
                            int result = moduleService.addModule(modules);
                            map.put("生成id为：",result);
                            map.put("code", 200);
                            map.put("msg", "添加成功");
                            return map;

                        } catch (Exception e) {

                            map.put("code", 201);
                            map.put("msg", "添加失败");
                            return map;
                        }
                        //提示ID为空
                    } else {
                        map.put("code", 201);
                        map.put("msg", "PrentID为空，请重新输入");
                        return map;
                    }
                }
                //提示模块名为空
            } else {
                map.put("code", 201);
                map.put("msg", "模块名为空，请输入模块名");
                return map;
            }
        }

        @ResponseBody
        @RequestMapping(value = "/putModule",method = RequestMethod.POST)
        public Map putModule(modules modules){

            Map<String, Object> map = new HashMap<>();

            logger.info("输入参数为：" + modules);

            //判断传入参数的名字不为空
            if (modules.getModuleName() != null) {
                //判断模块名是否已存在
                if (moduleService.search(modules.getModuleName()) != null) {
                    map.put("code", 201);
                    map.put("msg", "模块名已存在，请重新输入");
                    return map;
                } else {
                    //判断prentID不为空
                    if (modules.getPrentID() != null) {
                        //添加
                        try {
                            moduleService.putModule(modules);
                            map.put("code", 200);
                            map.put("msg", "修改成功");
                            return map;

                        } catch (Exception e) {

                            map.put("code", 201);
                            map.put("msg", "修改失败");
                            return map;
                        }
                        //提示ID为空
                    } else {
                        map.put("code", 201);
                        map.put("msg", "PrentID为空，请重新输入");
                        return map;
                    }
                }
                //提示模块名为空
            } else {
                map.put("code", 201);
                map.put("msg", "模块名为空，请输入模块名");
                return map;
            }
        }

        @ResponseBody
        @RequestMapping(value = "/{moduleId}",method = RequestMethod.DELETE)
        public Map deleteId(@PathVariable("moduleId") Integer moduleId){

            Map<String,Object> map = new HashMap<>();

            try {
                moduleService.deleteId(moduleId);

                map.put("code", 200);
                map.put("msg","删除成功");
                return map;

            }catch (Exception e) {

                map.put("code",201);
                map.put("msg","删除失败");
                return map;
            }
        }

    }
