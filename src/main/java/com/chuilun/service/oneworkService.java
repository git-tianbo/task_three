package com.chuilun.service;

import com.chuilun.dao.oneworkMapper;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.chuilun.pojo.onework;
import java.util.List;


public interface oneworkService {

    //主页面 重置
    public List<onework> findAll();

    //按名称 状态搜索
    public List<onework> search(String oneworkName, Integer state);

    //新增一个一级作品  返回ID
    public int addName(onework onework);

    //查询有多少列
    int countOne();

    //根据id查询当前状态
    int state(Integer oneId);

    //上线
    public boolean onLine(Integer oneId);

    //下线
    public boolean offLine(Integer oneId);

    //更改作品名称
    public boolean putName(onework onework);

    //根据id删除
    public boolean deleteId(Integer oneId);

}