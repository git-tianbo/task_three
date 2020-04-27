package com.chuilun.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.chuilun.pojo.account;

import java.util.List;


public interface accountMapper {

//    主页面/重置
    List<account> findAll();

//    根据条件搜索
    List<account> search(@Param("roleName") String roleName,@Param("username") String username);

//查找用户是否存在
    int loginByUser(String username);

//    根据用户名查询密码
    String getPassword(String username);

//    新增账户
    int addAccount(account account);

//    编辑账户
    boolean putAccount(account account);

//    根据ID删除账户
    boolean deleteId(Integer accountId);

}

