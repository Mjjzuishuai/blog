package com.baizhi.es.repository;

import com.baizhi.entity.Blog;

import java.util.List;

public interface BlogCustomerRepository {
    //多字段分词查所有并且高亮
    public List<Blog> findByTermAndHigh(String term);
}
