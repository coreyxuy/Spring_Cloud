package com.toloan.pay.service;

import com.github.pagehelper.Page;
import com.toloan.pay.pojo.ChannelSwitch;

import java.util.List;
import java.util.Map;

public interface ChannelSwitchService {

    /**
     * 获取全部ChannelSwitchs
     * @return
     */
    Page<ChannelSwitch> getChannelSwitchs(int current, int pageSize,String channelName);

    /**
     * 更新渠道信息
     * @param switchs
     */
    int updateSwitchs(ChannelSwitch switchs);

    /***
     * 插入渠道信息
     * @param switchs
     */
    String insert(ChannelSwitch switchs);


    ChannelSwitch getChannalCode(String channelCode);


    String removeSwitchs(String channelId);


    String  getChannalName(String channelId);
}
