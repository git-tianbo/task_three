package com.chuilun.service;

import com.chuilun.dao.moduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.chuilun.pojo.modules;

import java.util.List;


public interface moduleService{

    public List<modules> findAll();

    public List<modules> search(String moduleName);

    public int addModule(modules modules);

    public int putModule(modules modules);

    public int deleteId(Integer moduleId);


    }


