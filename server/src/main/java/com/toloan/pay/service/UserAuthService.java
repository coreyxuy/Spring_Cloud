package com.toloan.pay.service;

import com.toloan.pay.pojo.UserAuth;

/**
 * Created by ：Corey
 * 11:11 2018/8/17
 */
public interface UserAuthService {

    /**
     * 查询用户认证信息
     * @param userId
     * @return
     */
    UserAuth getUserInfo(Long userId);

    /**
     * 修改运营商状态
     * @return
     */
    int updateByPhoneState(Long userId);
}
