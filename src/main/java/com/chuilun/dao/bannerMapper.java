package com.chuilun.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.chuilun.pojo.banner;

import java.util.List;


public interface bannerMapper {

//    主页面
    List<banner> findAll();

//    根据状态 和 创建人 查找
    List<banner> search(@Param("state") Integer state,@Param("createBy") String createBy);

    //根据id查询状态
    int state(Integer id);

//    添加
    int  addBanner(banner banner);

//    更改url和配图
    boolean  putUrlAndPic(banner banner);

//    上线
    boolean  onLine(Integer id);

//下线
    boolean  offLine(Integer id);

//    根据id删除
    boolean  deleteId(Integer id);

}
