package com.chuilun.dao;

import com.chuilun.pojo.rolemodule;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface rolemoduleMapper {

    //批量插入rolemodule表
    public boolean  batch(List<rolemodule> rolemoduleList);

}


