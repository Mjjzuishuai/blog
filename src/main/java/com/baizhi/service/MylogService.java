package com.baizhi.service;

import com.baizhi.entity.Mylog;

import java.util.List;

/**
 * (Mylog)表服务接口
 *
 * @author makejava
 * @since 2019-12-04 21:28:20
 */
public interface MylogService {


    //查所有
    List<Mylog> queryAll(Mylog mylog);

    //添加一个
    void insert(Mylog mylog);


}