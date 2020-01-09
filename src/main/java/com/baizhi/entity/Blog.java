package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.lang.annotation.Documented;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "blogs",type = "blog")
public class Blog implements Serializable {
    @Id
    private String id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String summary;
    @Field(type = FieldType.Date)
    private Date  pubTime;
}
