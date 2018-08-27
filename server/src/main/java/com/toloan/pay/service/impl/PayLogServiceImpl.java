package com.toloan.pay.service.impl;

import com.toloan.pay.mapper.PayLogMapper;
import com.toloan.pay.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "PayLogService")
public class PayLogServiceImpl implements PayLogService {
    @Autowired
    private PayLogMapper payLogMapper;

    /**
     * 获取支付日志
     *
     * @return
     * @param id
     */
    @Override
    public String getPayLog(Long id) {
        return payLogMapper.selectByPrimaryKey(2L).getCardNo();
    }
}
