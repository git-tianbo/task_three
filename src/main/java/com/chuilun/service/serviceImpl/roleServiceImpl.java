package com.chuilun.service.serviceImpl;

import com.chuilun.dao.roleMapper;
import com.chuilun.pojo.role;
import com.chuilun.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class roleServiceImpl implements roleService {

    @Resource
    roleMapper roleMapper;

    //查询所有
    public List<role> findAll() {
        return roleMapper.findAll();
    }

    //根据名称搜索
    public role search(String roleName) {
        return roleMapper.search(roleName);
    }

    //根据角色名查询角色ID

    public int findRoleId(String roleName) {
        return roleMapper.findRoleId(roleName);
    }

    //添加角色 返回id
    public int addRole(role role) {
        roleMapper.addRole(role);
        return role.getRoleId();
    }

    //编辑角色
    public boolean putRole(role role) {
        return roleMapper.putRole(role);
    }

    public boolean deleteId(Integer roleId) {
        return false;
    }
}

