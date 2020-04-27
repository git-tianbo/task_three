package com.chuilun.dao;

import com.chuilun.pojo.modules;
import com.chuilun.pojo.role;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



public interface roleMapper {

    //主页面
    List<role> findAll();

    //搜索
    role search (String roleName);

    //根据角色名查询角色ID
    int  findRoleId(String roleName);

    //添加角色
    int addRole(role role);

    //编辑角色
    boolean putRole(role role);

    //删除角色
    boolean deleteId (Integer roleId);



    }




