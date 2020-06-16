package com.toloan.pay.service;

import com.github.pagehelper.Page;
import com.toloan.pay.pojo.ChannelLog;

import java.util.List;

public interface ChannelLogService {

    /**
     * 根据渠道号查询今日数据
     * @param channelId
     * @return
     */
    ChannelLog findTodayData(String channelId ) throws Exception;

    /**
     * 查看
     * @param channelId
     * @return
     */
    Page<ChannelLog> findHistoryData(String channelId , int currentPage, int pageSize);
}
