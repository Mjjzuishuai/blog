package com.baizhi.service;

import com.baizhi.aspect.Log;
import com.baizhi.dao.BlogDao;
import com.baizhi.entity.Blog;
import com.baizhi.entity.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDao dao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Blog> queryAll() {
        List<Blog> blogs = dao.queryAll();
        return blogs;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Blog queryOne(String id) {
        Blog blog = dao.queryOne(id);
        return blog;
    }

    @Override
    @Log(value = "他添加了一条数据")
    public void add(Blog blog) {

        blog.setPubTime(new Date());
        blog.setId(UUID.randomUUID().toString());

        dao.add(blog);
    }

    @Log(value = "他修改的一条数据")
    @Override
    public void upDate(Blog blog) {
        dao.upDate(blog);
    }


    @Log(value = "他删除了一条数据")
    @Override
    public void delete(String id) {
        dao.delete(id);
    }
}
