package com.chuilun.controller;


import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.chuilun.pojo.messages;
import com.chuilun.service.messagesService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * @Author: TianBo
  * @Description: 留言控制层
  * @Date: 2020/4/18
  **/

@Controller
@RequestMapping(value = "/messages")
public class messagesController {

    Logger logger = Logger.getLogger(messagesController.class);

    @Resource
    messagesService messagesService;

    /**
      * @Author: TianBo
      * @Description: 主页面
      * @Date: 2020/4/18
      * @return: java.util.Map
      **/

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map findAll() {

        Map<String, Object> map = new HashMap<>();

        try {
            List<messages> data = messagesService.findAll();
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

    /**
      * @Author: TianBo
      * @Description: 搜索功能
      * @Date: 2020/4/18
      * @Param threeworkName:
      * @Param state:
      * @return: java.util.Map
      **/

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Map search(@RequestParam(value = "threeworkName",required = false) String threeworkName, @RequestParam(value = "state",required = false)Integer state) {

        logger.info("输入的姓名为" + threeworkName + ",输入的状态为"+state);
        Map<String, Object> map = new HashMap<>();

        try {
            List<messages> data = messagesService.search(threeworkName,state);

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

    /**
      * @Author: TianBo
      * @Description: 添加留言内容
      * @Date: 2020/4/18
      * @Param messages:
      * @return: java.util.Map
      **/


    @ResponseBody
    @RequestMapping(value = "msg", method = RequestMethod.POST)
    public Map addMsg(messages messages) {
        Map<String, Object> map = new HashMap<>();

        logger.info("添加的留言信息为:"+messages);
        try {
           int result =  messagesService.addMsg(messages);

           logger.info("获取的id为："+result);
            map.put("生成的id为",result);
            map.put("code", 200);
            map.put("msg", "添加成功");
            return map;

        } catch (Exception e) {

            map.put("code", 201);
            map.put("msg", "添加失败");
            return map;
        }
    }

    /**
      * @Author: TianBo
      * @Description: 添加回复
      * @Date: 2020/4/18
      * @Param messages:
      * @return: java.util.Map
      **/

    @ResponseBody
    @RequestMapping(value = "reply", method = RequestMethod.POST)
    public Map addReply(messages messages) {

        logger.info("添加的回复为："+messages);

        Map<String, Object> map = new HashMap<>();

        try {
           messagesService.addReply(messages);

            map.put("code", 200);
            map.put("msg", "添加回复成功");
            return map;

        } catch (Exception e) {

            map.put("code", 201);
            map.put("msg", "添加回复失败");
            return map;

        }
    }

/**
  * @Author: TianBo
  * @Description: 更改状态   根据目前状态来设置相反状态
  * @Date: 2020/4/18
  * @Param msgId:
  * @return: java.util.Map
  **/

    @ResponseBody
    @RequestMapping(value = "state",method = RequestMethod.POST)
    public Map putState(Integer msgId) {

        logger.info("需要修改留言状态的Id为" + msgId);

        Map<String, Object> map = new HashMap<>();

        messagesService.findState(msgId);

//        如果传入的留言Id为0（普通留言）
        if (messagesService.findState(msgId)!=1) {
//              更改为精选留言
            messagesService.onLine(msgId);
            map.put("code", 200);
            map.put("msg", "设置精选留言成功");
        } else {
            messagesService.offLine(msgId);
            map.put("code", 200);
            map.put("msg", "取消精选留言成功");
        }
        return map;
    }



    /**
      * @Author: TianBo
      * @Description: 根据id删除
      * @Date: 2020/4/18
      * @Param msgId:
      * @return: java.util.Map
      **/

    @ResponseBody
    @RequestMapping(value = "/{msgId}",method = RequestMethod.DELETE)
    public Map deleteId(@PathVariable("msgId") Integer msgId){

        logger.info("要删除的id为:"+msgId);

        Map<String, Object> map = new HashMap<>();

        try {

            messagesService.deleteId(msgId);
            map.put("code", 200);
            map.put("msg", "删除成功");

        } catch (Exception e) {

            map.put("code", 201);
            map.put("msg", "删除失败");
        }
        return map;
    }

}


