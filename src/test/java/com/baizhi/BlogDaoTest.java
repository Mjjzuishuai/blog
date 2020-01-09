package com.baizhi;

import com.baizhi.dao.BlogDao;
import com.baizhi.entity.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(value= SpringRunner.class)
@SpringBootTest(classes = Mjj.class)
public class BlogDaoTest {
    @Autowired
    BlogDao dao;
    @Test
    public void BlogDaoTest(){
        List<Blog> blogs = dao.queryAll();
        System.out.println(blogs);
    }
    @Test
    public void addTest(){
        Blog blog = new Blog("4", "sdfsd", "dsafsd", new Date());
        dao.add(blog);
    }
}
