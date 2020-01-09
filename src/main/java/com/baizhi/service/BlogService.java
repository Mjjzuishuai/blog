package com.baizhi.service;

import com.baizhi.entity.Blog;

import java.util.List;

public interface BlogService {
    /*queryAll*/
    public List<Blog> queryAll();
    /*chayige*/
    public Blog queryOne(String id);
    /*tianjia*/
    public void add(Blog blog);
    /*xiugai*/
    public void upDate(Blog blog);
    /*shanchu*/
    public void delete(String id);
}
