package com.baizhi.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//运行时机（代表在目标方法执行过程中执行通知方法）
@Retention(RetentionPolicy.RUNTIME)
//此注解代表运行在方法上还是类上
@Target(ElementType.METHOD)
public @interface Log {
    String value();
}
