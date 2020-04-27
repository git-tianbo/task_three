package com.chuilun.service;

import com.chuilun.dao.threeworkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.chuilun.pojo.threework;

import java.util.List;


public interface threeworkService {

//查询所有
    public List<threework> findAll();

//搜索
    public List<threework> search(String threeworkName,Integer state);

    //根据id查询状态
    public int state(Integer threeId);

//添加用户
    public int addThree(threework threework);

//更改用户
    public boolean putThree(threework threework);

//上线
    public boolean onLine(Integer threeId);

//下线
    public boolean offLine(Integer threeId);

//删除
    public boolean deleteId(Integer threeId);
}