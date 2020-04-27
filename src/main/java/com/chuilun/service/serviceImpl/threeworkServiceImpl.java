package com.chuilun.service.serviceImpl;

import com.chuilun.dao.threeworkMapper;
import com.chuilun.pojo.threework;
import com.chuilun.service.threeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("threeworkService")
public class threeworkServiceImpl implements threeworkService {

    @Resource
    threeworkMapper threeworkMapper;

    @Override
    public List<threework> findAll() {
        return threeworkMapper.findAll();
    }

    @Override
    public List<threework> search(String threeworkName, Integer state) {
        return threeworkMapper.search(threeworkName,state);
    }

    @Override
    public int state(Integer threeId) {
        return threeworkMapper.state(threeId);
    }

    @Override
    public int addThree(threework threework) {
         threeworkMapper.addThree(threework);
            return threework.getThreeId();
    }
    @Override
    public boolean putThree(threework threework) {
        return threeworkMapper.putThree(threework);
    }

    @Override
    public boolean onLine(Integer threeId) {
        return threeworkMapper.onLine(threeId);
    }

    @Override
    public boolean offLine(Integer threeId) {
        return threeworkMapper.offLine(threeId);
    }

    @Override
    public boolean deleteId(Integer threeId) {
        return threeworkMapper.deleteId(threeId);
    }
}