package com.baizhi;


import com.baizhi.dao.MylogDao;
import com.baizhi.entity.Mylog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = Mjj.class)
public class MylogDaoTest {
    @Autowired
    MylogDao mylogDao;


    @Test
    public void insertDaoTest() {
        Mylog mylog = new Mylog("2", "吗佳君", new Date(), "操作", "成功");
        mylogDao.insert(mylog);
    }

    @Test
    public void queryAllTest() {
        List<Mylog> mylogs = mylogDao.queryAll(null);
        for (Mylog mylog : mylogs) {
            System.out.println(mylog);
        }
    }
}
