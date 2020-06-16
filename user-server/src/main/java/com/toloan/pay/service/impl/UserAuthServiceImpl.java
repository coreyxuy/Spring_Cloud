package com.toloan.pay.service.impl;

import com.toloan.pay.mapper.UserAuthMapper;
import com.toloan.pay.pojo.UserAuth;
import com.toloan.pay.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ：Corey
 * 11:11 2018/8/17
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Override
    public UserAuth getUserInfo(Long userId) {
        return userAuthMapper.getUserAutah(userId);
    }

    @Override
    public int updateByPhoneState(Long userId) {
        return  userAuthMapper.updateByPhoneState(userId);
    }

}
