package com.toloan.pay.mapper;

import com.toloan.pay.pojo.ChannelUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 渠道用户表Dao
 *
 * @author JJH
 * @version 1.0.0
 * @date 2018-08-16 23:05:22
 */
@Component


public interface ChannelUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelUser record);

    int insertSelective(ChannelUser record);

    int save(ChannelUser channelUser);

    ChannelUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelUser record);

    int updateByPrimaryKey(ChannelUser record);

    /**
     * 后台管理页面 查询用户
     * @param username
     * @return
     */
    ChannelUser getChannelUser(String username);

    /**
     * 修改密码
     * @param map
     * @return
     */
    int updatePassword(Map<String, Object> map);

    /**
     * 判断是否存在渠道
     * @param channelCode
     */
    int getChannelUserCode(String channelCode);
}