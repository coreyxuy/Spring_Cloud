package com.toloan.pay.mapper;

import com.toloan.pay.pojo.SmsTpl;

public interface SmsTplMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsTpl record);

    int insertSelective(SmsTpl record);

    SmsTpl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsTpl record);

    int updateByPrimaryKey(SmsTpl record);

    SmsTpl getTpl(String type);
}