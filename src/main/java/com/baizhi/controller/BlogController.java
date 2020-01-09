package com.baizhi.controller;

import com.baizhi.entity.Blog;
import com.baizhi.entity.BlogUser;
import com.baizhi.service.BlogService;
import com.baizhi.util.MarkdownToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    BlogService service;
    @RequestMapping("queryAll")
    @ResponseBody
    public List<Blog> queryAll(HttpSession session){
        List<Blog> blogs = service.queryAll();
        return blogs;
    }
    @RequestMapping("queryOne")
    public String queryOne(String id, Model model){
        Blog blog = service.queryOne(id);
        model.addAttribute("blog",blog);
        return "forward:/jsp/update.jsp";
    }


    @RequestMapping("upDate")
    public String upDate(Blog blog){
        blog.setPubTime(new Date());
        service.upDate(blog);
        return "redirect:/jsp/main.jsp";
    }


    @RequestMapping("add")
    public String add(Blog blog){
        service.add(blog);
        return "redirect:/jsp/main.jsp";
    }
    @RequestMapping("delete")
    public String delete(String id,String oper){
        if("del".equals(oper)) {
            service.delete(id);
        }
        return "redirect:/jsp/main.jsp";
    }

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Blog> blogs = service.queryAll();
        model.addAttribute("blogs",blogs);
        return "jsp/frontshow";
    }


    @RequestMapping("findOne")
    public String findOne(String id, Model model){
        Blog blog = service.queryOne(id);
        //将markdown转为Html
        String summary = blog.getSummary();
        String parse = MarkdownToHtml.parse(summary);
        blog.setSummary(parse);
        model.addAttribute("blog",blog);
        return "jsp/showOne";
    }
}
