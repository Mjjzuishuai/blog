package com.baizhi;

import com.baizhi.dao.BlogUserDao;
import com.baizhi.entity.BlogUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(value= SpringRunner.class)
@SpringBootTest(classes = Mjj.class)
public class UserDaoTest {
    @Autowired
    BlogUserDao dao;
    @Test
    public void userDaoTest(){
        BlogUser user = dao.queryOne("小黑");
        System.out.println(user);
    }
}
