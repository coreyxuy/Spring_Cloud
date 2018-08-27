package com.toloan.pay.mapper;

import com.toloan.pay.pojo.UserAuth;
import com.toloan.pay.pojo.UserDetail;

public interface UserAuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    UserAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);

    /**
     * 查询用户认证信息
     * @param userId
     * @return
     */
     UserAuth getUserAutah(Long userId);

    /**
     * 跟新用户状态
     * @param userAuth
     * @return
     */
    int updateByUserId(UserAuth userAuth);

    /**
     * 修改运营商状态
     * @return
     */
    int updateByPhoneState(Long userId);
}