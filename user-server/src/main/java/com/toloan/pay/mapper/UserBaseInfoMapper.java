package com.toloan.pay.mapper;

import com.toloan.pay.pojo.UserBaseInfo;
import org.springframework.stereotype.Component;

@Component
public interface UserBaseInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserBaseInfo record);

    int insertSelective(UserBaseInfo record);

    UserBaseInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBaseInfo record);

    int updateByPrimaryKey(UserBaseInfo record);
}