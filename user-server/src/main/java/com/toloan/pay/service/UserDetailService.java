package com.toloan.pay.service;

import com.toloan.pay.pojo.UserDetail;

import java.util.Map; /**
 * Created by ：Corey
 * 19:49 2018/8/15
 * 用户详情
 */
public interface UserDetailService {


    int updateUserDetail(UserDetail userDetail);


    /**
     *获取用户认证信息
     * @param userId
     * @param phone
     * @return
     */
    UserDetail getUserInfo(Long userId, String phone);

    /**
     * 根据userId查询出对象
     * @param userId
     * @return
     */
    UserDetail getInfoByUserId(long userId);
}
