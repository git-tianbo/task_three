package com.chuilun.service;

import com.chuilun.dao.studioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.chuilun.pojo.studio;

import java.util.List;


public interface studioService{

    List<studio> findAll();

    List<studio> search(String studioName, Integer state);

    int  state(Integer id);

    int addStudio(studio studio);

    boolean putStudio(studio studio);

    boolean onLine(Integer id);

    boolean offLine(Integer id);

    boolean deleteId(Integer id);

}
