package com.toloan.pay.mapper;

import com.github.pagehelper.Page;
import com.toloan.pay.pojo.ChannelSwitch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import com.toloan.pay.pojo.ChannelSwitch;

/**
 * 渠道号及对应转化率表Dao
 * 
 * @author JJH
 * @version 1.0.0
 * @date 2018-08-16 23:05:03
 * Copyright 杭州民华金融信息服务有限公司  cashloan All Rights Reserved
 * 官方网站：www.yongqianbei.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
@Component
public interface ChannelSwitchMapper {

    /**
     * 判断渠道号是否存在
     * @param channelCode
     * @return
     */
    ChannelSwitch getChannalCode(String channelCode);
    /**
     * 存储信息
     * @param channelSwitch
     * @return
     */
    int save(ChannelSwitch channelSwitch);

    /**
     * 获取全部渠道信息
     * @return
     */
    Page<ChannelSwitch> getAllChannel();


    /**
     * 获取全部渠道信息
     * @return
     */
    Page<ChannelSwitch> getAllChannelSys(String channelName);



    /**
     * 根据channel号查询开关数据
     * @param channelId
     * @return
     */
    ChannelSwitch findByChannel(String channelId);

    /**
     * 更新渠道信息
     * @param switchs
     */
    int update(ChannelSwitch switchs);

    /**
     *
     * @return
     * @param channelId
     */
    String delSwitchs(String channelId);


    /**
     * 跟新渠道
     * @param switchs
     * @return
     */
    int updateSelective(ChannelSwitch switchs);

    /**
     * 查询是否存在相同id
     * @param channelName
     * @return
     */
    String getChannalName(String channelId);
}
