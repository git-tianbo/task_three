package com.chuilun.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.chuilun.pojo.threework;

import java.util.List;


public interface threeworkMapper {

    //    主页面/重置
    List<threework> findAll();

    //根据条件搜索
    List<threework> search(@Param("threeworkName") String threeworkName,@Param("state") Integer state);

    //根据id查询上下架状态
    int state(Integer threeId);

    //添加作品
    int addThree(threework threework);

    //更改作品内容
    boolean putThree(threework threework);

    //上架
    boolean onLine(Integer threeId);

    //下架
    boolean offLine(Integer threeId);

    //删除作品
    boolean deleteId(Integer threeId);

}
