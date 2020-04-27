package com.chuilun.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.chuilun.pojo.onework;
import java.util.List;


public interface oneworkMapper {

    //主页面/重置
    List<onework>  findAll();

    //根据姓名和状态查询
    List<onework>  search(@Param("oneworkName") String oneworkName,@Param("state") Integer state);


    //查询表中的记录数
    int  countOne();

    //根据id查询状态
    int state(Integer oneId);

    // 根据姓名查询ID
    int findIdByName(String oneworkName);

    //增加姓名
    int addName (onework onework);

    //更改姓名
    boolean  putName(onework onework);

    //上线
    boolean onLine(Integer oneId);

    //下线
    boolean offLine(Integer oneId);

    //删除
    boolean deleteId(Integer oneId);

}
