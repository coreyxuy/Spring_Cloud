package com.toloan.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.toloan.pay.pojo.OperatorReqLog;

import java.io.IOException;
import java.util.Map;

public interface OperatorReqLogService {

    /**
     * 插入请求记录
     * @param operatorReqLog
     * @return
     */
    int insert(OperatorReqLog operatorReqLog);

    /**
     * 根据orderId查询订单
     * @param orderNo
     * @return
     */
    OperatorReqLog findSelective(String orderNo);

    /**
     * 魔蝎运营商数据解析
     * @param finalDataTemp
     * @param userId
     * @param log
     */
    void saveMXOperatorInfos(JSONObject finalDataTemp, Long userId, OperatorReqLog log);

    /**
     * 查询数据
     * @param temp
     * @return
     */
    JSONObject mxOperatorQuery(Map<String, String> temp) throws IOException;
}
