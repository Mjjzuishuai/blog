package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//表示当前项目为springboot项目
@SpringBootApplication
//给dao包扫描
@MapperScan(basePackages = "com.baizhi.dao")
public class Mjj {
    public static void main(String[] args) {

        SpringApplication.run(Mjj.class,args);
    }
}
