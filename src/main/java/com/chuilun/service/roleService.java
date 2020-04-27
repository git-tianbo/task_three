package com.chuilun.service;

import com.chuilun.dao.roleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.chuilun.pojo.role;

import java.util.List;



public interface roleService {

    //查询所有
    public List<role> findAll();

    //根据名称搜索
    public role search(String roleName);

    //根据角色名查询角色ID
    int  findRoleId(String roleName);

    //添加角色 返回id
    public int addRole(role role);

    //编辑角色
    public boolean putRole(role role);

    //根据id删除
    public boolean deleteId(Integer roleId);
}
