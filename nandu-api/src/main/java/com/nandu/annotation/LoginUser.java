package com.nandu.annotation;

import java.lang.annotation.*;

/**
 * 登录用户信息
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
