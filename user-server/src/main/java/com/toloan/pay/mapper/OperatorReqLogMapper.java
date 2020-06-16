package com.toloan.pay.mapper;

import com.toloan.pay.pojo.OperatorReqLog;

import java.util.Map;

/**
 * 运营商数据认证
 */
public interface OperatorReqLogMapper {

    int save(OperatorReqLog reqLog);

    OperatorReqLog findSelective(String orderNo);
}
