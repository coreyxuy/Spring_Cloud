package com.toloan.pay.mapper;

import com.toloan.pay.pojo.PayLog;

public interface PayLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PayLog record);

    int insertSelective(PayLog record);

    PayLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PayLog record);

    int updateByPrimaryKey(PayLog record);
}