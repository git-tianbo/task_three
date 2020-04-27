package com.chuilun.service.serviceImpl;

import com.chuilun.dao.oneworkMapper;
import com.chuilun.dao.twoworkMapper;
import com.chuilun.pojo.twowork;
import com.chuilun.service.twoworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("twoworkService")
public class twoworkServiceImpl implements twoworkService {

    @Resource
    twoworkMapper twoworkMapper;

    @Resource
    oneworkMapper oneworkMapper;

//    查找全部
    public List<twowork> findAll() {
        return twoworkMapper.findAll();
    }

//    搜索
    public List<twowork> search(String twoworkName, Integer state) {
        return twoworkMapper.search(twoworkName,state);
    }

    //根据id查询状态
    public int  state(Integer twoId){
        return  twoworkMapper.state(twoId);
    }

//    添加
    public int addTwo(String twoworkName,String oneworkName) {

//        根据传入的一级作品的名称  获取一级作品ID
        int oneId = oneworkMapper.findIdByName(oneworkName);

//        创建twowork对象
        twowork twowork = new twowork();
        twowork.setTwoworkName(twoworkName);
        twowork.setOneId(oneId);

        //调用dao层添加接口  传入twowork对象
        twoworkMapper.addTwo(twowork);
//        获取刚刚新建二级作品的自增长ID
        return twowork.getTwoId();
    }


//    修改名称
    public boolean putName(twowork twowork) {
        return twoworkMapper.putName(twowork);
    }

//上线
    public boolean onLine(Integer twoId) {
        return twoworkMapper.onLine(twoId);
    }

//下线
    public boolean offLine(Integer twoId) {
        return twoworkMapper.offLine(twoId);
    }

    //    删除
    public boolean deleteId(Integer twoId) {
        return twoworkMapper.deleteId(twoId);
    }
}
