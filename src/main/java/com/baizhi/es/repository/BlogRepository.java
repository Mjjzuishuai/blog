package com.baizhi.es.repository;

import com.baizhi.entity.Blog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BlogRepository extends ElasticsearchRepository<Blog,String> {

}
