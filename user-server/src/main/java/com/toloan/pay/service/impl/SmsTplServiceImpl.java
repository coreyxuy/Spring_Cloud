package com.toloan.pay.service.impl;

import com.toloan.pay.mapper.SmsTplMapper;
import com.toloan.pay.pojo.SmsTpl;
import com.toloan.pay.service.SmsTplService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 短信记录ServiceImpl
 * 
 * @author lyang
 * @version 1.0.0
 * @date 2017-03-13 18:36:01
 * Copyright 杭州民华金融信息服务有限公司  arc All Rights Reserved
 * 官方网站：www.yongqianbei.com
 * 
 * 未经授权不得进行修改、复制、出售及商业使用
 */
@Service(value = "SmsTplService")
public class SmsTplServiceImpl implements SmsTplService {
	
	private static final Logger logger = LoggerFactory.getLogger(SmsTplServiceImpl.class);
   
    @Resource
    private SmsTplMapper clSmsTplMapper;

	@Override
	public SmsTpl getTpl(String type) {
		return clSmsTplMapper.getTpl(type);
	}
	
}