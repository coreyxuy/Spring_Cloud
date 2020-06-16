package com.toloan.pay.service;

import com.toloan.pay.pojo.SystemUser;

/**
 * Created by ：Corey
 * 20:48 2018/8/20
 * 系统管理员
 */
public interface SystemUserService {

    SystemUser getSystemUser(String username);
}
