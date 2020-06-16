package com.toloan.pay.controller;

import com.toloan.pay.dto.PayLogDTO;
import com.toloan.pay.exception.SimpleMessageException;
import com.toloan.pay.service.PayLogService;
import com.toloan.response.ResponseCode;
import com.toloan.response.ServerResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




/**
 *
 *
 * @author pantheon
 * @version 1.0.0
 * @date 2018/7/20
 * Copyright 杭州民华金融信息服务有限公司 All Rights Reserved
 * 官方网站：www.yongqianbei.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class PayController {

    @Autowired
    private PayLogService payLogService;

    @ApiOperation(value = "根据id查询支付记录", notes = "url参数获取支付记录")
    @ApiImplicitParam(name = "id", value = "支付记录ID", required = true, dataType = "Long", paramType = "query")
    @PostMapping("/create")
    public ServerResponse create(@RequestParam (value = "id")Long id) {
        if (id == 2)
            throw new SimpleMessageException(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        String op = payLogService.getPayLog(id);
        return ServerResponse.createBySuccess(op);
    }

    @ApiOperation(value = "根据表单查询支付记录", notes = "采用表单的格式获取支付记录")
    @PostMapping("/createForm")
    public ServerResponse createForm( PayLogDTO payLogDTO) {
        String op = payLogService.getPayLog(payLogDTO.getId());
        return ServerResponse.createBySuccess(op);
    }

    @ApiOperation(value = "根据json查询支付记录", notes = "采用json的格式获取支付记录")
    @PostMapping("/createJson")
    public ServerResponse createJson(@RequestBody PayLogDTO payLogDTO) {
        String op = payLogService.getPayLog(payLogDTO.getId());
        return ServerResponse.createBySuccess(op);
    }

}
