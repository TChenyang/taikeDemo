package com.nandu.common.aspect;

import com.nandu.common.exception.NanDuException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RedisAspect {

    private Logger logger = LoggerFactory.getLogger(RedisAspect.class);

    /**
     * 是否开启redis缓存  true开启   false关闭
     */
    @Value("${nandu.redis.open: false}")
    private boolean open;

    @Around("execution(* com.nandu.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        Object result = null;
        if (open){
            try {
                result = point.proceed();
            }catch (Exception e){
                logger.error("redis error",e);
                throw new NanDuException("Redis服务异常");
            }
        }
        return result;
    }

}
