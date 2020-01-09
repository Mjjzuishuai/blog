package com.baizhi.es.repository;

import com.baizhi.entity.Blog;
import lombok.SneakyThrows;
import org.aspectj.weaver.ast.Var;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class BlogCustomerRepositoryImpl implements BlogCustomerRepository {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    //查询所有并且高亮
    public List<Blog> findByTermAndHigh(String term){
        HighlightBuilder.Field field = new HighlightBuilder
                .Field("*")
                .requireFieldMatch(false)
                .preTags("<font color='red'>")
                .postTags("</font>");

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery(term).field("title").field("summary"))
                .withHighlightFields(field)
                .build();
        AggregatedPage<Blog> blogs = elasticsearchTemplate.queryForPage(build, Blog.class, new SearchResultMapper() {
            @SneakyThrows
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                SearchHit[] hits = searchResponse.getHits().getHits();
                List<Blog> list = new ArrayList<>();
                for (SearchHit hit : hits) {
                    Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                    for (String s : highlightFields.keySet()) {
                        sourceAsMap.put(s, highlightFields.get(s).getFragments()[0]);
                    }
                    Blog blog = MapToBlog(sourceAsMap);
                    list.add(blog);
                }
                return new AggregatedPageImpl<T>((List<T>) list);
            }
        });
        return blogs.getContent();
    }

    public Blog MapToBlog(Map<String, Object> sourceAsMap) throws ParseException {
        Blog blog = new Blog();
        blog.setId(sourceAsMap.get("id").toString());
        blog.setTitle(sourceAsMap.get("title").toString());
        blog.setSummary(sourceAsMap.get("summary").toString());
        String strTime = sourceAsMap.get("pubTime").toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(strTime);
        blog.setPubTime(date);
        return blog;
    }
}
