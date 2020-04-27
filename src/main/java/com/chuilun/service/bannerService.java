package com.chuilun.service;

import com.chuilun.dao.bannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.chuilun.pojo.banner;
import java.util.List;


public interface bannerService{

    public List<banner> findAll();

    public List<banner> search(Integer state, String createBy);

    public int state(Integer id);

    public int addBanner(banner banner);

    public boolean putUrlAndPic(banner banner);

    public boolean onLine(Integer id);

    public boolean offLine(Integer id);

    public boolean deleteId(Integer id);
}