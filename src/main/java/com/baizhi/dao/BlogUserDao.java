package com.baizhi.dao;

import com.baizhi.entity.BlogUser;

import java.util.List;

public interface BlogUserDao {
    public List<BlogUser> queryAll();

    public BlogUser queryOne(String name);
}
