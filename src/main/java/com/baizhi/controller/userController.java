package com.baizhi.controller;

import com.baizhi.entity.BlogUser;
import com.baizhi.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class userController {
    @Autowired
    BlogUserService service;
    @RequestMapping("login")
    public String login(HttpSession session,String name,String password){
        BlogUser user = service.queryOne(name);
        if(user==null){
            return "error";
        }else {
            if(password.equals(user.getPassword())){
                session.setAttribute("adminName",user.getName());
                return "redirect:/back/back.jsp";
            }else {
                return "error";
            }
        }
    }
}
