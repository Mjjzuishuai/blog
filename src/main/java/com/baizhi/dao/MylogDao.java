package com.baizhi.dao;

import com.baizhi.entity.Mylog;

import java.util.List;

/**
 * (Mylog)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-04 21:28:20
 */
public interface MylogDao {


    //查所有
    List<Mylog> queryAll(Mylog mylog);

    //添加
    void insert(Mylog mylog);


}