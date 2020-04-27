package com.chuilun.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.chuilun.pojo.studio;

import java.util.List;


public interface studioMapper {

    //主页面/重置
    List<studio> findAll();

    //根据姓名和状态查询
    List<studio>  search(@Param("studioName") String studioName,@Param("state") Integer state);

    //根据id查询状态
    int state(Integer id);

    //增加姓名
    int addStudio(studio studio);

    //更改简介类型   图片  正文
    boolean putStudio(studio studio);

    //    上线
    boolean onLine(Integer id);

    //    下线
    boolean offLine(Integer id);

    //根据id删除
    boolean deleteId(Integer id);




}
