package com.baizhi;

import com.baizhi.entity.Blog;
import com.baizhi.es.repository.BlogCustomerRepository;
import com.baizhi.es.repository.BlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = Mjj.class)
public class TestBlogEs {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    BlogCustomerRepository blogCustomerRepository;

    //测试添加一个

    @Test
    public void testAdd() {
        Blog blog = new Blog("1234", "小码", "很帅", new Date());
        blogRepository.save(blog);
    }

    @Test
    public void testHigh() {
        List<Blog> list = blogCustomerRepository.findByTermAndHigh("码");
        for (Blog blog : list) {
            System.out.println("blog = " + blog);
        }
    }
}
