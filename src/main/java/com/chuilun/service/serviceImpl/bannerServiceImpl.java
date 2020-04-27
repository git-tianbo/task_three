package com.chuilun.service.serviceImpl;

import com.chuilun.dao.bannerMapper;
import com.chuilun.pojo.banner;
import com.chuilun.service.bannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("bannerService")
public class bannerServiceImpl implements bannerService {

    @Resource
    bannerMapper bannerMapper;

    public List<banner> findAll() {
        return bannerMapper.findAll();
    }

    public List<banner> search(Integer state, String createBy) {
        return bannerMapper.search(state, createBy);
    }

    public int state(Integer id){
        return bannerMapper.state(id);
    }

    public int addBanner(banner banner) {
        bannerMapper.addBanner(banner);
        return banner.getId();
    }

    public boolean putUrlAndPic(banner banner) {
        return bannerMapper.putUrlAndPic(banner);
    }

    public boolean onLine(Integer id) {
        return bannerMapper.onLine(id);
    }

    public boolean offLine(Integer id) {
        return bannerMapper.offLine(id);
    }

    public boolean deleteId(Integer id) {
        return bannerMapper.deleteId(id);

    }
}