package com.chuilun.service.serviceImpl;

import com.chuilun.dao.oneworkMapper;
import com.chuilun.pojo.onework;
import com.chuilun.service.oneworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("oneworkService")
public class oneworkServiceImpl implements oneworkService {

    @Resource
    oneworkMapper oneworkMapper;

    @Override
    public List<onework> findAll() {
        return oneworkMapper.findAll();
    }

    @Override
    public List<onework> search(String oneworkName, Integer state) {
        return oneworkMapper.search(oneworkName,state);
    }

    @Override
    public int state(Integer oneId) {
        return oneworkMapper.state(oneId);
    }

    @Override
    public int countOne() {
        return oneworkMapper.countOne();
    }

    @Override
    public int addName(onework onework) {
        oneworkMapper.addName(onework);
        return onework.getOneId();
    }

    @Override
    public boolean onLine(Integer oneId) {
        return oneworkMapper.onLine(oneId);
    }

    @Override
    public boolean offLine(Integer oneId) {
        return oneworkMapper.offLine(oneId);
    }

    @Override
    public boolean putName(onework onework) {
        return oneworkMapper.putName(onework);
    }

    @Override
    public boolean deleteId(Integer oneId) {
        return oneworkMapper.deleteId(oneId);
    }
}