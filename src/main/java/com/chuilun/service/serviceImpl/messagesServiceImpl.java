package com.chuilun.service.serviceImpl;

import com.chuilun.dao.messagesMapper;
import com.chuilun.pojo.messages;
import com.chuilun.service.messagesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("messagesService")
public class messagesServiceImpl implements messagesService {


    @Resource
    messagesMapper messagesMapper;

    @Override
    public List<messages> findAll() {
        return messagesMapper.findAll();
    }

    @Override
    public List<messages> search(String threeworkName, Integer state) {
        return messagesMapper.search(threeworkName, state);
    }

    @Override
    public int findState(Integer msgId) {
        return messagesMapper.findState(msgId);
    }

    @Override
    public int addMsg(messages messages) {

        messagesMapper.addMsg(messages);

        return messages.getMsgId();

    }

    @Override
    public boolean addReply(messages messages) {
        return messagesMapper.addReply(messages);
    }

    @Override
    public boolean onLine(Integer msgId) {
        return messagesMapper.onLine(msgId);
    }

    @Override
    public boolean offLine(Integer msgId) {
        return messagesMapper.offLine(msgId);
    }

    @Override
    public boolean deleteId(Integer msgId) {
        return messagesMapper.deleteId(msgId);
    }
}

















