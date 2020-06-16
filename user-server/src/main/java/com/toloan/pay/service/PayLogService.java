package com.toloan.pay.service;

/**
 * 
 * 支付记录服务
 * @author pantheon
 * @version 1.0.0
 * @date 2018/7/24
 * Copyright 杭州民华金融信息服务有限公司 All Rights Reserved
 * 官方网站：www.yongqianbei.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public interface PayLogService {
    /**
     * 获取支付日志
     *
     * @param
     * @param id
     * @return
    */
    String getPayLog(Long id);
}
