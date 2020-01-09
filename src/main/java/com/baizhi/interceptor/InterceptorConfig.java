package com.baizhi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器
        registry.addInterceptor(myInterceptor).
                addPathPatterns("/mylog/*")
                .addPathPatterns("/blog/queryAll")
                .addPathPatterns("/blog/queryOne")
                .addPathPatterns("/blog/upDate")
                .addPathPatterns("/blog/queryOne")
                .addPathPatterns("/blog/add");
    }
}
