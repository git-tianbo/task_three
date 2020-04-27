package com.chuilun.service.serviceImpl;

import com.chuilun.dao.moduleMapper;
import com.chuilun.pojo.modules;
import com.chuilun.service.moduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("moduleService")
public class moduleServiceImpl implements moduleService {

    @Resource
    moduleMapper moduleMapper;

    public List<modules> findAll() {
        return moduleMapper.findAll();
    }

    public List<modules> search(String moduleName) {
        return moduleMapper.search(moduleName);
    }

    public int addModule(modules modules) {
        moduleMapper.addModule(modules);
        return modules.getModuleId();
    }

    public int putModule(modules modules) {
        return moduleMapper.putModule(modules);
    }

    public int deleteId(Integer moduleId) {
        return moduleMapper.deleteId(moduleId);
    }
}


