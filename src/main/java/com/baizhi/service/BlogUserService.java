package com.baizhi.service;

import com.baizhi.entity.BlogUser;

import java.util.List;

public interface BlogUserService {
    public List<BlogUser> queryAll();
    public BlogUser queryOne(String name);
}
