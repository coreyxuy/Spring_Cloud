package com.toloan.pay.service;

import com.toloan.pay.pojo.SmsTpl;

/**
 * 短信记录Service
 * 
 * @author lyang
 * @version 1.0.0
 * @date 2017-03-13 18:36:01
 * Copyright 杭州民华金融信息服务有限公司  arc All Rights Reserved
 * 官方网站：www.yongqianbei.com
 * 
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public interface SmsTplService {

    SmsTpl getTpl(String type);
}
