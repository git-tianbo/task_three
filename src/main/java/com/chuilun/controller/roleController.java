package com.chuilun.controller;

import com.chuilun.pojo.modules;
import com.chuilun.pojo.role;
import com.chuilun.pojo.rolemodule;
import com.chuilun.service.roleService;
import com.chuilun.service.rolemoduleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.scope.MethodScope;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/role")
public class roleController {

    Logger logger = Logger.getLogger(roleController.class);

    @Resource
    rolemoduleService rolemoduleService;

    @Resource
    roleService roleService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            List<role> data = roleService.findAll();

            logger.info("查询结果为："+data);
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
    public Map search(String roleName) {
        Map<String, Object> map = new HashMap<>();

        logger.info("输入roleName参数为"+roleName);
        try {
            role role = roleService.search(roleName);

            logger.info("查询结果为："+role);

            map.put("data", role);
            map.put("code", 200);
            map.put("msg", "搜索成功!");
            return map;
        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "未找到,请重新输入!");
            return map;
        }
    }

    //新增角色
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map addRole(@RequestParam("roleName") String roleName, @RequestBody List<Integer> moduleIdList) {

        logger.info("输入参数eoleName为："+roleName+",集合为："+moduleIdList);
        Map<String, Object> map = new HashMap<>();

        try {
            role role = new role();
            role.setRoleName(roleName);
            //  新建角色返回ID
            int roleId = roleService.addRole(role);

            //  根据传来的模块id，生成角色模块中间表的list
            List<rolemodule> rolemoduleList = new ArrayList<>();

            for (Integer moduleId : moduleIdList) {
                rolemodule rolemodule = new rolemodule();
                rolemodule.setRoleId(roleId);
                rolemodule.setModuleId(moduleId);
                rolemoduleList.add(rolemodule);
            }
            //  最后 批量添加关联关系
            rolemoduleService.batch(rolemoduleList);
            map.put("code", 200);
            map.put("msg", "添加角色成功！");
            return map;
        }catch (Exception e){
            map.put("code", 201);
            map.put("msg", "添加角色失败，请重新尝试！");
            return map;
        }
    }


//    编辑角色
    @ResponseBody
    @RequestMapping(value = "/putRole",method = RequestMethod.POST)
    public Map putRole(@RequestParam("roleName") String roleName,
                      @RequestParam("roleId") Integer roleId,
                      @RequestBody List<Integer> moduleIdList) {

        logger.info("输入参数eoleName为："+roleName+"roleId为："+roleId+",集合为："+moduleIdList);

        Map<String, Object> map = new HashMap<>();

//        try {
            //  更改角色
            role role = new role();
            role.setRoleName(roleName);
            role.setRoleId(roleId);
            roleService.putRole(role);

            //  根据传来的模块id，生成角色模块中间表的list
            List<rolemodule> rolemoduleList = new ArrayList<>();

            for (Integer moduleId : moduleIdList) {
                rolemodule rolemodule = new rolemodule();
                rolemodule.setRoleId(roleId);
                rolemodule.setModuleId(moduleId);
                rolemoduleList.add(rolemodule);
            }
            //  最后 批量添加关联关系
            rolemoduleService.batch(rolemoduleList);
            map.put("code", 200);
            map.put("msg", "更改角色成功！");
            return map;
//        }catch (Exception e){
//            map.put("code", 201);
//            map.put("msg", "更改角色失败，请重新尝试！");
//            return map;
//        }
    }


    @ResponseBody
    @RequestMapping(value = "/{roleId}",method = RequestMethod.DELETE)
    public Map deleteId(@PathVariable("roleId") Integer roleId) {

        logger.info("传入的ID为"+roleId);

        Map<String, Object> map = new HashMap<>();

        try {
            roleService.deleteId(roleId);
            map.put("code", 200);
            map.put("msg", "删除成功!");
            return map;
        } catch (Exception e) {
            map.put("code", 201);
            map.put("msg", "删除失败,请重新尝试!");
            return map;
        }
    }

}



