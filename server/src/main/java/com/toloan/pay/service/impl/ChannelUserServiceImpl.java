package com.toloan.pay.service.impl;

import com.toloan.pay.mapper.ChannelUserMapper;
import com.toloan.pay.pojo.ChannelUser;
import com.toloan.pay.service.ChannelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by ：Corey
 * 19:57 2018/8/20
 * 后台用户信息
 */
@Service(value = "ChannelUserService")
public class ChannelUserServiceImpl implements ChannelUserService {
    @Autowired
    private ChannelUserMapper channelUserMapper;

    @Override
    public ChannelUser getChannelUser(String username) {
        return channelUserMapper.getChannelUser(username);
    }

    /**
     * 修改密码
     * @param map
     * @return
     */
    @Override
    public int updatePassword(Map<String, Object> map) {
        return channelUserMapper.updatePassword(map);
    }
}
