package com.chuilun.service.serviceImpl;

import com.chuilun.dao.studioMapper;
import com.chuilun.pojo.studio;
import com.chuilun.service.studioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studioService")
public class studioServiceImpl implements studioService {

    @Resource
    studioMapper studioMapper;


    @Override
    public List<studio> findAll() {
        return studioMapper.findAll();
    }

    @Override
    public List<studio> search(String studioName, Integer state) {
        return studioMapper.search(studioName,state);
    }

    @Override
    public int state(Integer id) {
        return studioMapper.state(id);
    }

    @Override
    public int addStudio(studio studio) {
        studioMapper.addStudio(studio);
        return studio.getId();
    }

    @Override
    public boolean putStudio(studio studio) {
        return studioMapper.putStudio(studio);
    }

    @Override
    public boolean onLine(Integer id) {
        return studioMapper.onLine(id);
    }

    @Override
    public boolean offLine(Integer id) {
        return studioMapper.offLine(id);
    }

    @Override
    public boolean deleteId(Integer id) {
        return studioMapper.deleteId(id);
    }

}