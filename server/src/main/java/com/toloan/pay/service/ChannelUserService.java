package com.toloan.pay.service;

import com.toloan.pay.pojo.ChannelUser;

import java.util.Map;

/**
 * Created by ：Corey
 * 19:57 2018/8/20
 */
public interface ChannelUserService {

    ChannelUser getChannelUser(String username);

    /**
     * 修改用户密码
     * @param map
     */
    int updatePassword(Map<String, Object> map);
}
