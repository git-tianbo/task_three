package com.chuilun.service;

import com.chuilun.dao.messagesMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.chuilun.pojo.messages;

import java.util.List;
import java.util.logging.Logger;


public interface messagesService {

    //    主页面跳转  重置
    List<messages> findAll();

    //  按作品名（作品表）  状态  搜索
    List<messages> search(@Param("threeworkName") String threeworkName,@Param("state") Integer state);

    //根据id查询目前的留言状态
    int findState(Integer msgId);

    //新增留言
    int addMsg(messages messages);

    //添加回复(实际是更改reply)
    boolean addReply(messages messages);


    //设为精选留言
    boolean onLine(Integer msgId);

    //设为普通留言
    boolean offLine(Integer msgId);

    //    删除按钮
    boolean deleteId(Integer msgId);

}





