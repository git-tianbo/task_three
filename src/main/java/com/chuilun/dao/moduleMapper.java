package com.chuilun.dao;


import org.springframework.stereotype.Repository;
import com.chuilun.pojo.modules;

import java.util.List;


public interface moduleMapper {

    //查找全部
    List<modules> findAll();

    //搜索相关内容
    List<modules> search(String moduleName);

    //新增模块
    int addModule(modules modules);

    //编辑模块
    int putModule(modules modules);

    //根据id删除
    int deleteId(Integer moduleId);

}
