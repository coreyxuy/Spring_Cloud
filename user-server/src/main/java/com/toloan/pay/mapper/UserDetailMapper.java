package com.toloan.pay.mapper;

import com.toloan.pay.pojo.UserDetail;

public interface UserDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);

    /**
     * 手机号和用户id去顶用户唯一
     * @param userId
     * @param phone
     * @return
     */
    UserDetail getUserInfo(Long userId, String phone);

    /**
     * 通过用户id 查询用户信息
     * @param userId
     * @return
     */
    UserDetail getInfoByUserId(long userId);
}