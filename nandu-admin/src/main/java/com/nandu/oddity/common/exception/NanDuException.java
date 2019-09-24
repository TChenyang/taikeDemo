package com.nandu.oddity.common.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理器
 */
public class NanDuException {

    private Logger log = LoggerFactory.getLogger(NanDuException.class);

    /**
     * 处理自定义异常
     */
    /*@ExceptionHandler(NanDuException.class)
    public R handlenNanDuException(NanDuException E){

    }*/

}
