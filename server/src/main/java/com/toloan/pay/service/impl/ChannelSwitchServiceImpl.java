package com.toloan.pay.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.toloan.pay.mapper.ChannelSwitchMapper;
import com.toloan.pay.pojo.ChannelLog;
import com.toloan.pay.pojo.ChannelSwitch;
import com.toloan.pay.service.ChannelSwitchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.toloan.pay.mapper.ChannelUserMapper;
import com.toloan.pay.pojo.ChannelSwitch;
import com.toloan.pay.pojo.ChannelUser;
import com.toloan.pay.service.ChannelSwitchService;
import com.toloan.pay.utils.PasswordUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ：Corey
 * 10:59 2018/8/20
 * 渠道号及对应转化率实现
 */
@Service(value = "ChannelSwitchService")
public class ChannelSwitchServiceImpl implements ChannelSwitchService {

    @Resource
    private ChannelSwitchMapper channelSwitchMapper;
    @Resource
    private ChannelUserMapper channelUserMapper;

    /**
     * 判断渠道号是否存在且是否开启
     * @param channelCode
     * @return
     */
    @Override
    public ChannelSwitch getChannalCode(String channelCode) {
        return channelSwitchMapper.getChannalCode(channelCode);
    }

    /**
     * 删除渠道信息
     * @param channelId
     * @return
     */
    @Override
    public String removeSwitchs(String channelId) {
        return channelSwitchMapper.delSwitchs(channelId);
    }

    /**
     * 查询是否存在相同渠道号
     * @param channelId
     * @return
     */
    @Override
    public String getChannalName(String channelId) {
        return  channelSwitchMapper.getChannalName(channelId);
    }


    @Override
    public Page<ChannelSwitch> getChannelSwitchs(int current, int pageSize ,String channelName) {
        PageHelper.startPage(current, pageSize);
        if (channelName == null){
            Page<ChannelSwitch> allChannel = channelSwitchMapper.getAllChannel();
            return (Page<ChannelSwitch>) allChannel;
        }else {
            Page<ChannelSwitch> allChannel = channelSwitchMapper.getAllChannelSys(channelName);
            return (Page<ChannelSwitch>) allChannel;
        }
    }



    @Override
    public int updateSwitchs(ChannelSwitch switchs) {
       return  channelSwitchMapper.update(switchs);
    }

    @Override
    public String insert(ChannelSwitch switchs) {
        // 插入switchs渠道信息
        int i = channelSwitchMapper.save(switchs);
        // 插入用户登录信息
        if(i > 0){
            ChannelUser user = new ChannelUser();
            user.setName(switchs.getChannelName());
            user.setLoginName(switchs.getChannelId());
            String pwd = PasswordUtils.get6Pwd();
            user.setPassword(pwd);
            user.setCreateTime(new Date());
            channelUserMapper.save(user);
            return pwd;
        }
        return null;
    }
}
