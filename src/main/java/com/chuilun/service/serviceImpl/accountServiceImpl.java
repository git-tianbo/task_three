package com.chuilun.service.serviceImpl;

import com.chuilun.dao.accountMapper;
import com.chuilun.pojo.account;
import com.chuilun.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class accountServiceImpl implements accountService {

    @Resource
    accountMapper accountMapper;

    //主页面重置
    public List<account> findAll() {

        return accountMapper.findAll();
    }

    //根据条件搜索
    public List<account> search(String roleName, String username) {

        return accountMapper.search(roleName, username);
    }

    //判断账户是否存在
    public boolean loginByUser(String username) {

        if (accountMapper.loginByUser(username)>=1) {
            System.out.print("账户名已存在");
            return true;

        } else {
            System.out.print("账户名不存在");
            return false;
        }
    }

    //根据账户获得密码

    public String getPassword(String username) {

        return accountMapper.getPassword(username);
    }

    //    判断密码是否大于6位数
    public boolean passwordSize(String password) {

        String size = "^[a-zA-Z]{6,30}$";//定义手机密码规则

        return password.matches(size);
    }

    //添加账户
    public int addAccount(account account) {
        accountMapper.addAccount(account);
        return account.getAccountId();
    }

    //更改账户
    public boolean putAccount(account account) {

        return accountMapper.putAccount(account);
    }

    //删除账户
    public boolean deleteId(Integer accountId) {

        return accountMapper.deleteId(accountId);
    }
}