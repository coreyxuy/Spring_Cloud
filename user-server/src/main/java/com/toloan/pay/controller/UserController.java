package com.toloan.pay.controller;

import com.toloan.pay.mapper.BorrowProgressMapper;
import com.toloan.pay.mapper.UserAuthMapper;
import com.toloan.pay.pojo.BorrowProgress;
import com.toloan.pay.pojo.ChannelSwitch;
import com.toloan.pay.pojo.UserAuth;
import com.toloan.pay.pojo.UserDetail;
import com.toloan.pay.service.*;
import com.toloan.pay.utils.RedisCommon;
import com.toloan.pay.utils.RegexUtils;
import com.toloan.pay.vo.AppAbsActionWrapper;
import com.toloan.response.ServerResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pantheon
 * @version 1.0.0
 * @date 2018/8/13
 * Copyright 杭州民华金融信息服务有限公司 All Rights Reserved
 * 官方网站：www.yongqianbei.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService iUserService;
    @Autowired
    private SmsService smsService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private UserAuthService userAuthService;
    @Autowired
    private UserAuthMapper userAuthMapper;
    @Autowired
    private ChannelSwitchService channelSwitchService;
    @Autowired
    private BorrowProgressMapper borrowProgressMapper;
    @Autowired
    private BorrowProgressService borrowProgressService;



    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @param loginName
     * @param loginPwd
     * @param vcode
     * @param channelCode
     */
    @RequestMapping("register")
    @ResponseBody
    public void wxRegister(final HttpServletRequest request,
                           final HttpServletResponse response, final String loginName,
                           final String loginPwd, final String vcode,
                           final String channelCode ) {
        new AppAbsActionWrapper(response) {
            @Override
            public Object doAction() {
                ServerResponse result = iUserService.registerUser(request, loginName,
                        loginPwd.toUpperCase(), vcode,
                        "h5", channelCode);
                return result;
            }
        };
    }


    /**
     * 用户登录
     * @param request
     * @param loginName 用户名(手机号)
     * @param loginPwd  用户密码
     * @return
     */
    @ApiOperation(value = "用户登录")
    @PostMapping("/api/pay/login")
    public Object login(HttpServletRequest request, String loginName, String loginPwd, String channelCode) {
        ServerResponse resp = iUserService.login(request, loginName, loginPwd, channelCode);
        if (resp.isSuccess()) {
            return ServerResponse.createBySuccess("登录成功!", resp.getData());
        } else {
            return resp;
        }

    }


    /**
     * 发送验证码
     * 2018/8/14
     * @param
     * @return
     */
    @RequestMapping("/api/pay/postMobileCode")
    @ResponseBody
    public Object postMobileCode(final HttpServletRequest request, final HttpServletResponse response, final String phone) {
        //校验
        if (!RegexUtils.checkMobile(phone)) {
            return ServerResponse.createByErrorMessage("手机号格式错误,请确认之后重新输入");
        }
        String old = redisService.get(RedisCommon.SMS_REGISTER_CODE + phone);
        if (StringUtils.isNotBlank(old)) {
            return ServerResponse.createByErrorMessage("操作频繁请稍后再试！");
        }
        //生成6个随机数字
//        String code = RandomStringUtils.randomNumeric(6);
//        redisService.set(phone, code, 60 * 10);
        String register = smsService.sendSmsByTpl(request, phone, "register");
        return ServerResponse.createBySuccess(register);
    }


    /**
     * 用户信息认证
     *
     * @param userId
     * @param userName
     * @param idNo
     * @param zhiMa
     * @param amount
     * @return
     */
    @RequestMapping("/api/pay/save")
    @ResponseBody
    private Object saveInformation(@RequestParam(value = "userId") Long userId,
                                   @RequestParam(value = "userName") String userName,
                                   @RequestParam(value = "idNo") String idNo,
                                   @RequestParam(value = "zhiMa") String zhiMa,
                                   @RequestParam(value = "qqNo") String qqNo,
                                   @RequestParam(value = "weChat") String wechat,
                                   @RequestParam(value = "amount") String amount,
                                   @RequestParam(value = "channelCode",required = false) String channelCode) {
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(userId);
        userDetail.setRealName(userName);
        userDetail.setIdNo(idNo);
        userDetail.setZhima(zhiMa);
        userDetail.setQq(String.valueOf(qqNo));
        userDetail.setWechat(wechat);
        userDetail.setAmount(amount);
        userDetail.setCreateTime(new Date());
        int user = userDetailService.updateUserDetail(userDetail);
        if (user == 1) {
            //得到用戶主鍵
            UserAuth userAuth = new UserAuth();
            userAuth.setUserId(userId);
            userAuth.setIdState("30");
            userAuth.setIdStateTime(new Date());
            userAuth.setZhimaState("30");
            userAuth.setZhimaStateTime(new Date());
            userAuth.setQqState("30");
            userAuth.setQqStateTime(new Date());
            userAuth.setTaobaoState("30");
            userAuth.setTaobaoStateTime(new Date());
            userAuthMapper.updateByUserId(userAuth);
            return ServerResponse.createBySuccess();
        } else {
            return ServerResponse.createByError();
        }


    }

    /**
     * 用户认证信息
     *
     * @param userId
     * @return
     */
    @RequestMapping("/api/pay/info")
    @ResponseBody
    private Object Information(@RequestParam(value = "userId") Long userId
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        UserAuth userAuth = userAuthService.getUserInfo(userId);
        //获取用户借款状态
        BorrowProgress borrowProgress = borrowProgressService.getBorrowDetail(userId);
        String status = borrowProgress.getStatus();
        if (userAuth != null) {
            map.put("userInfo", userAuth);
            map.put("borrowStatus" ,status);
            return ServerResponse.createBySuccess(map);
        } else {
            return ServerResponse.createByError();
        }
    }


    /**
     * 用户借款
     * @param userId
     * @param channelCode
     * @return
     */
    @RequestMapping("/api/pay/borrow")
    @ResponseBody
    private Object borrow(@RequestParam(value = "userId") Long userId,
                          @RequestParam(value = "channelCode") String channelCode) {
        BorrowProgress borrow = borrowProgressService.getBorrowProgress(userId, channelCode);
        if (borrow == null) {
            return ServerResponse.createByErrorMessage("渠道不存在..!");
        }
        ChannelSwitch channelSwitch = channelSwitchService.getChannalCode(channelCode);
        String status = channelSwitch.getSwitchs();
        if (status != null && status.equals("20")) {
            borrowProgressService.updateBorrowStatus(userId);
            return ServerResponse.createBySuccess("false");
        }
        borrowProgressService.updateBorrowSta(userId);
        return ServerResponse.createBySuccess();
        }


}
