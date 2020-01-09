package com.baizhi.service;

import com.baizhi.dao.BlogUserDao;
import com.baizhi.entity.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogUserServiceImpl implements BlogUserService {
    @Autowired
    BlogUserDao dao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<BlogUser> queryAll() {
        List<BlogUser> Users = dao.queryAll();
        return Users;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public BlogUser queryOne(String name) {
        BlogUser user = dao.queryOne(name);
        return user;
    }
}
