package com.toloan.pay.service;

import com.toloan.pay.pojo.User;
import com.toloan.response.ServerResponse;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 用户服务接口
 *
 * @author pantheon
 * @version 1.0.0
 * @date 2018/8/13
 * Copyright 杭州民华金融信息服务有限公司 All Rights Reserved
 * 官方网站：www.yongqianbei.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public interface UserService {

    /**
     * 登陆
     * 2018/8/14
     * @param
     * @return
     */
    ServerResponse login(HttpServletRequest request, String loginName, String loginPwd, String channelCode);


    /**
     * 发送短信
     * 2018/8/14
     * @param
     * @return
     */
    ServerResponse postMobileCode(String mobile);


    /**
     * 注册
     * 2018/8/14
     * @param
     * @return
     */
    ServerResponse registerUser(HttpServletRequest request, String phone, String pwd, String vcode,
                            String regClient,String channelCode);

    /**
     *
     * @param userId
     * @param channelCode
     */
    User getChannelCode(Long userId, String channelCode);

    /**
     * 用户id获取用户手机号
     * @param userId
     * @return
     */
    User getPhone(Long userId );

    /**
     * 根据主键获取对象
     * @param userId
     * @return
     */
    User findById(long userId);
}
