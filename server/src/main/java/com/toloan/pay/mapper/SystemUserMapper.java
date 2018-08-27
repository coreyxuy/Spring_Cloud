package com.toloan.pay.mapper;

import com.toloan.pay.pojo.SystemUser;

/**
 * Created by ：Corey
 * 20:45 2018/8/20
 */
public interface SystemUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SystemUser getSystemUser(String username);
}
