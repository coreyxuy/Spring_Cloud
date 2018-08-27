package com.toloan.pay.mapper;

import com.toloan.pay.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int countPhone(Map<String, Object> map);

    User getUserByMobile(Map<String, Object> map);

    /**
     * 判断用户是否存在
     * @param userId
     * @param channelCode
     * @return
     */
    User getChannelCode(Long userId, String channelCode);

    /**
     * 获取用户对应的手机号
     * @param userId
     * @return
     */
    User getPhone(Long userId);

    String getUserChannelCode(Long userId);
}