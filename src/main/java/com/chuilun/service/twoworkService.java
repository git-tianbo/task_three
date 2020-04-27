package com.chuilun.service;

import com.chuilun.dao.twoworkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.chuilun.pojo.twowork;

import java.util.List;


public interface twoworkService {

    List<twowork> findAll();

    List<twowork> search(String twoworkName, Integer state);

    int state(Integer twoId);

    int addTwo(String twoworkName,String oneworkName);

    boolean putName(twowork twowork);

    boolean  onLine(Integer twoId);

    boolean  offLine(Integer twoId);

    boolean deleteId(Integer twoId);

}
