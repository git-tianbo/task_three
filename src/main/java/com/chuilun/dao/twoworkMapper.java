package com.chuilun.dao;

import com.chuilun.pojo.onework;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.chuilun.pojo.twowork;

import java.util.List;



public interface twoworkMapper {

    //    主页面/重置
    List<twowork>  findAll();

    //    查找
    List<twowork> search(@Param("twoworkName") String twoworkName,@Param("state") Integer state);

    //新增2级作品集名称   且添加其所属1级作品集名称
    int addTwo(twowork twowork);

//    根据id查询目前的状态
    int state(Integer twoId);

    //    更改作品集分类名
    boolean  putName(twowork twowork);

    //    上架
    boolean  onLine(Integer twoId);

    //    下架
    boolean  offLine(Integer twoId);

    //  根据id删除
    boolean deleteId(Integer twoId);

}
