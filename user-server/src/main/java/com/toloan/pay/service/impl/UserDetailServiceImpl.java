package com.toloan.pay.service.impl;

import com.toloan.pay.cache.Global;
import com.toloan.pay.mapper.UserDetailMapper;
import com.toloan.pay.mapper.UserMapper;
import com.toloan.pay.pojo.UserDetail;
import com.toloan.pay.service.UserDetailService;
import com.toloan.pay.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ：Corey
 * 19:50 2018/8/15
 */
@Service(value = "userDetail")
@Slf4j
public class UserDetailServiceImpl implements UserDetailService {

    //钱庄地址导流
    private final String url = "http://192.168.0.150:8088/api/h5/shareUser.htm";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public int updateUserDetail(UserDetail userDetail) {
        String idCard = userDetail.getIdNo();
        String userName = userDetail.getRealName();
        String mobile = userDetail.getPhone();
        String channelName = userMapper.getUserChannelCode(userDetail.getUserId());
        if (channelName != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Map<String, Object> map = new HashMap<>();
                    String big_dipper = Global.getValue("Big_Dipper");
                    map.put("idCard", idCard);
                    map.put("userName", userName);
                    map.put("mobile", mobile);
                    map.put("channelName", channelName);
                    log.info("进入北斗星导流...." + userName);
                    String s = HttpClientUtil.get(big_dipper, map);
                }
            }).start();
        }
        return userDetailMapper.updateByPrimaryKey(userDetail);
    }

    @Override
    public UserDetail getUserInfo(Long userId, String phone) {
        return  userDetailMapper.getUserInfo(userId,phone);
    }

    @Override
    public UserDetail getInfoByUserId(long userId) {
        return userDetailMapper.getInfoByUserId(userId);
    }
}
