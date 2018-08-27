package com.toloan.pay.service.impl;

import com.toloan.pay.mapper.SystemUserMapper;
import com.toloan.pay.pojo.SystemUser;
import com.toloan.pay.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ：Corey
 * 20:48 2018/8/20
 * 系统管理员登录
 */
@Service(value = "SystemUserService")
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public SystemUser getSystemUser(String username) {
        return systemUserMapper.getSystemUser(username);
    }
}
