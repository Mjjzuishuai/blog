package com.baizhi.service;

import com.baizhi.entity.Mylog;
import com.baizhi.dao.MylogDao;
import com.baizhi.service.MylogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (Mylog)表服务实现类
 *
 * @author makejava
 * @since 2019-12-04 21:28:20
 */
@Transactional
@Service("mylogService")
public class MylogServiceImpl implements MylogService {
    @Autowired
    MylogDao mylogDao;

   //查所有
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Mylog> queryAll(Mylog mylog) {
        return this.mylogDao.queryAll(mylog);
    }


    //添加一个
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(Mylog mylog) {
        mylog.setId(UUID.randomUUID().toString());
        this.mylogDao.insert(mylog);
    }
}