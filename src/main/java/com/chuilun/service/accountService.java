package com.chuilun.service;

import com.chuilun.dao.accountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.chuilun.pojo.account;
import java.util.List;


public interface accountService {

    //主页面重置
    public List<account> findAll();

    //根据条件搜索
    public List<account> search(String roleName, String username);

     //判断账户是否存在+
    public boolean loginByUser(String username);

    //根据账户获得密码
    public String getPassword(String username);

//    判断密码是否大于6位数
    public boolean passwordSize(String password);

    //添加账户
    public int addAccount(account account);

    public boolean putAccount(account account);

    public boolean deleteId(Integer accountId);
}
