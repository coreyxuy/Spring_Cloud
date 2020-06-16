package com.toloan.pay.Interceptor;

import com.toloan.pay.exception.SimpleMessageException;
import com.toloan.response.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 *
 * @author pantheon
 * @version 1.0.0
 * @date 2018/7/24
 * Copyright 杭州民华金融信息服务有限公司 All Rights Reserved
 * 官方网站：www.yongqianbei.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
@ControllerAdvice
@Slf4j
public class ExceptionInterceptor {
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(Exception ex) {
        log.error("系统发生异常{}",ex.getMessage());
        return  ServerResponse.createByErrorCodeMessage(500,"系统发生异常");
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = SimpleMessageException.class)
    public Object myErrorHandler(SimpleMessageException ex) {
        return  ServerResponse.createByErrorCodeMessage(ex.getErrorCode(),ex.getMessage());
    }

}
