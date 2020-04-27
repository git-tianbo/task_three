package com.chuilun.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.chuilun.pojo.messages;

import java.util.List;


public interface messagesMapper {

    //    查询所有
    List<messages>  findAll();

    //    条件搜索
    List<messages> search(@Param("threeworkName") String threeworkName,@Param("state") Integer state);

    //根据id查询目前的留言状态
    int findState(Integer msgId);

    //添加留言
    int addMsg(messages messages);

    //添加回复
    boolean addReply(messages messages);

//  精选留言
    boolean onLine(Integer msgId);

//   普通留言
    boolean offLine(Integer msgId);

//    删除留言
    boolean deleteId(Integer msgId);

}
