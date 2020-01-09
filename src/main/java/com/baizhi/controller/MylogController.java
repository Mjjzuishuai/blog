package com.baizhi.controller;


import com.baizhi.entity.Mylog;
import com.baizhi.service.MylogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mylog")
public class MylogController {
    @Autowired
    MylogService mylogService;

    //查所有
    @RequestMapping("queryAll")
    @ResponseBody
    public List<Mylog> queryAll(){
        List<Mylog> mylogs = mylogService.queryAll(null);
        return mylogs;
    }
}
