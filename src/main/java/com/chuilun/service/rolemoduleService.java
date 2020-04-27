package com.chuilun.service;

import com.chuilun.dao.rolemoduleMapper;
import com.chuilun.pojo.rolemodule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public  interface rolemoduleService  {

    //批量插入实现
    public boolean batch(List<rolemodule> rolemoduleList);

}
