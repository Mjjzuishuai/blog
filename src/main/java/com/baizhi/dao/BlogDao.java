package com.baizhi.dao;

import com.baizhi.entity.Blog;

import java.util.List;

public interface BlogDao {
    /*查所有*/
    public List<Blog> queryAll();
    /*查一个*/
    public Blog queryOne(String id);
    /*添加一个*/
    public void add(Blog blog);
    /*修改*/
    public void upDate(Blog blog);
    /*删除*/
    public void delete(String id);
}
