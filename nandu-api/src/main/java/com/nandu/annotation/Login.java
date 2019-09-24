package com.nandu.annotation;

import java.lang.annotation.*;

/*
* 登录验证
* */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
