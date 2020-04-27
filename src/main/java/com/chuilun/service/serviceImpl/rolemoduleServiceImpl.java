package com.chuilun.service.serviceImpl;

import com.chuilun.dao.rolemoduleMapper;
import com.chuilun.pojo.rolemodule;
import com.chuilun.service.rolemoduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("rolemoduleService")
public class rolemoduleServiceImpl implements rolemoduleService {

    @Resource
    rolemoduleMapper rolemoduleMapper;

    //批量插入实现
    public boolean batch(List<rolemodule> rolemoduleList) {

        return rolemoduleMapper.batch(rolemoduleList);
    }
}