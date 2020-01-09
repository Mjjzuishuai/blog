package com.baizhi.aspect;

import com.baizhi.entity.Mylog;
import com.baizhi.service.MylogService;
import com.sun.tools.doclint.Checker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class MyAspect {
    @Autowired
    MylogService mylogService;
    //注入session对象
    @Autowired
    HttpServletRequest request;

    /*创建环绕通知*/
    @Around(value = "pt()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //什么人
        Object o = request.getSession().getAttribute("adminName");
        String adminName = (String) o;
        //什么时间
        Date date = new Date();
        //干了什么
        /*String methodName = proceedingJoinPoint.getSignature().getName();*/
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Log annotation = signature.getMethod().getAnnotation(Log.class);
        String value = annotation.value();

        //结果是什么
        String flag = "操作成功";
        try {
            //调用目标类方法
            Object proceed = proceedingJoinPoint.proceed();
            flag = "操作失败";
            return proceed;
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            /* System.out.println(adminName+date+methodName+flag);*/
            /*  log.info("{},{},{},{}", adminName, date, value, flag);*/
            Mylog mylog = new Mylog(null, adminName, date, value, flag);
            mylogService.insert(mylog);
        }
    }

    //配置切入点
    //切记自定义注解只适用于代理方式cglib方式
    @Pointcut(value = "@annotation(com.baizhi.aspect.Log)")
    public void pt() {
    }
}
