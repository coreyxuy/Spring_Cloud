package com.toloan.pay.mapper;

import com.toloan.pay.pojo.ChannelLog;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 渠道每日数据记录表Dao
 * 
 * @author JJH
 * @version 1.0.0
 * @date 2018-08-16 23:04:29
 */
@Component
public interface ChannelLogMapper {

    /**
     * 保存数据
     * @param channelLog
     * @return
     */
    int save(ChannelLog channelLog);

    /**
     * 根据渠道号查询当日数据
     * @param channelId
     * @return
     */
    ChannelLog findToday(String channelId);

    /**
     * 根据渠道号获取真实注册人数
     * @param channelId
     * @return
     */
    Integer getRegisterNum(String channelId);

    /**
     * 更新对象
     * @param todayLog
     */
    void update(ChannelLog todayLog);

    /**
     * 查询历史记录
     * @param channelId
     * @return
     */
    List<ChannelLog> findHistoryData(String channelId);
}
