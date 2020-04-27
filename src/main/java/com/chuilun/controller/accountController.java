package com.chuilun.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import com.chuilun.pojo.account;
import com.chuilun.service.accountService;
import com.chuilun.service.roleService;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class accountController {


        Logger logger= Logger.getLogger(accountController.class);

         @Resource
        roleService roleService;

         @Resource
        accountService accountService;

        //如何登录
        @ResponseBody
        @RequestMapping(value = "/login",method = RequestMethod.POST)
        public Map login(@RequestParam("username") String username, @RequestParam("password") String password) {

            Map<String,Object> map = new HashMap<>();

            logger.info("输入的用户名为:"+username+",密码为："+password);

            //根据账户名    判断数据库中有无此用户
            if (accountService.loginByUser(username)==false){
               map.put("msg","用户名不存在,请重新输入！");
               map.put("code",201);
                return map;
            }else{
                //根据输入的密码    和通过用户名查询的密码做对比  如果符合  则登录成功
                //更改登录状态  跳转到登录成功页面
                if (password.equals(accountService.getPassword(username))){
                    map.put("msg","登录成功");
                    map.put("'code","200");
                    return map;
                }else{
                    //如果账户名和密码不符合  跳转回来 重新输入
                    map.put("msg","密码错误,请重新输入");
                    map.put("code","201");
                    return map;
                }
            }
        }

    //主页面 查询
    @ResponseBody
        @RequestMapping(method= RequestMethod.GET)
        public Map findAll(){

        Map<String,Object> map = new HashMap<>();

            try {
                List<account> data = accountService.findAll();

                logger.info("查询结果为："+data);

                map.put("data", data);
                map.put("code", 200);
                map.put("msg","进入账户页面成功!");
                return map;

            }catch (Exception e) {
                map.put("code",201);
                map.put("msg","进入账户页面失败!");
                return map;
            }
        }

        //搜索账户
        @ResponseBody
        @RequestMapping(value = "/search",method = RequestMethod.GET)
        public Map search(@RequestParam(value = "roleName",required = false)String roleName,@RequestParam(value = "username",required = false)String username){

            Map<String,Object> map = new HashMap<>();

            logger.info("输入参数roleName为："+roleName+"，username为："+username);

            try {
                List<account> data =accountService.search(roleName,username);

                logger.info("查询出的结果为"+data);

                map.put("data", data);
                map.put("code", 200);
                map.put("msg","搜索成功!");
                return map;

            }catch (Exception e) {

                map.put("code",201);
                map.put("msg","搜索失败，请重新输入搜索条件！");
                return map;
            }
        }


        //创建新账户
        @ResponseBody
        @RequestMapping(method = RequestMethod.POST)
        public Map addAccount(@RequestBody account account,@RequestParam("roleName") String roleName) {

            Map<String,Object> map = new HashMap<>();

            logger.info("输入的参数acoount为："+account+",roleName为"+roleName);

            //如果账户不存在
            if (accountService.loginByUser(account.getUsername())==false) {

                //且密码是否大于6位数
//                if(accountService.passwordSize(account.getPassword())==true) {

                if(account.getPassword().length()>6){

//                    根据传入的角色名返回角色ID
                    int id = roleService.findRoleId(roleName);
//                    account里加入roleId
                    account.setRoleId(id);

                    //添加账户(用户  密码  关联的roleId)
                    int result = accountService.addAccount(account);
                    map.put("生成id为：",result);
                    map.put("code", 200);
                    map.put("msg", "注册成功");
                    return map;
                    }else{
                    map.put("code", 201);
                    map.put("msg", "密码必须大于6位数");
                    return map;
                }
            } else {
                map.put("msg", "账户已存在,请更换账户名注册或直接登录");
                return map;
            }
        }


        //更改
        @ResponseBody
        @RequestMapping(value = "/putAccount",method = RequestMethod.POST)
        public Map putAccount(@RequestBody account account,@RequestParam("roleName")String roleName){

            Map<String,Object> map = new HashMap<>();

            logger.info("传入的参数为："+account);

//            根据传入的角色名, 获取roleId
            int id = roleService.findRoleId(roleName);
//          account里加入roleId
            account.setRoleId(id);

            try {
                accountService.putAccount(account);
                map.put("code", 200);
                map.put("msg","更改成功");
                return map;

            }catch (Exception e) {

                map.put("code",201);
                map.put("msg","更改失败");
                return map;
            }
        }


        //根据id删除
        @ResponseBody
        @RequestMapping(value = "/{accountId}",method = RequestMethod.DELETE)
        public Map deleteId(@PathVariable("accountId") Integer accountId){

            Map<String,Object> map = new HashMap<>();

            try {
                accountService.deleteId(accountId);

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





