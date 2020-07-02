package com.toloan.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.toloan.pay.cache.Global;
import com.toloan.pay.pojo.*;
import com.toloan.pay.service.*;
import com.toloan.response.ServerResponse;
import com.toloan.utils.OrderNoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/operator")
@Slf4j
public class MxController  {

    @Resource
    private UserDetailService userDetailService;
    @Resource
    private OperatorReqLogService operatorReqLogService;
    @Resource
    private ChannelSwitchService channelSwitchService;
    @Resource
    private UserAuthService userAuthService;
    @Resource
    private UserService userService;




    @PostMapping(value = "/api/act/mine/operator/operatorCredit.htm")
    public ServerResponse operatorCredit(@RequestParam(value = "userId") long userId,
                                         @RequestParam(value = "channelCode")String channelCode) throws UnsupportedEncodingException {
        //判断渠道号是否存在
        ChannelSwitch channalCode = channelSwitchService.getChannalCode(channelCode);
        if (channalCode != null && channalCode.getSwitchs().equals("10")){

        String orderNo = OrderNoUtil.getSerialNumber();
        //魔蝎运营商认证
        OperatorReqLog operatorReqLog = new OperatorReqLog(userId,orderNo,"400");
        operatorReqLog.setRespTime(new Date());
        operatorReqLog.setBusinessType("50");
        String operatorIdentifyUrl= Global.getValue("operator_moxie_url");
        if(operatorIdentifyUrl != null){
            UserDetail userBaseInfo = userDetailService.getInfoByUserId(userId);
            User user = userService.findById(userId);
            if(userBaseInfo!=null){
                String realName = userBaseInfo.getRealName();//真实姓名
                realName = StringUtils.deleteWhitespace(realName);//去掉空格

                realName =URLEncoder.encode(realName, "utf-8");

                realName= new String(realName.getBytes(),"UTF-8");
                String idNo = userBaseInfo.getIdNo();//身份证
                idNo = StringUtils.deleteWhitespace(idNo);//去掉空格
                String phone = user.getPhone();//获取用户的电话号码
                operatorIdentifyUrl = operatorIdentifyUrl +"&userId="+orderNo+"&carrier_phone="+phone+"&carrier_name="+realName+"&carrier_idcard="+idNo;
            }
            Map<String,Object> params=new HashMap<String,Object>();
            params.put("orderNo", orderNo);
            log.info("魔蝎运营商认证,获取第三方URL:"+operatorIdentifyUrl);
            operatorReqLog.setRespCode("200");
            operatorReqLog.setRespParams(operatorIdentifyUrl);
            operatorReqLog.setOrderNo(orderNo);
            operatorReqLogService.insert(operatorReqLog);
            return ServerResponse.createBySuccess("",operatorIdentifyUrl);

        }else {
            log.info("魔蝎认证授权地址为空:" + operatorIdentifyUrl);
            operatorReqLogService.insert(operatorReqLog);
            return ServerResponse.createByError();
            }
        }
        UserAuth userAuth = new UserAuth();
        userAuth.setPhoneState(String.valueOf(30));
        userAuth.setPhoneStateTime(new Date());
        userAuthService.updateByPhoneState(userId);
        return ServerResponse.createBySuccess();
    }

    /**
     * @description 运营商运营商异步回掉
     */
    @GetMapping(value = "/mx/operatorCallback.htm")
    public void operatorCallback(@RequestBody JSONObject obj,HttpServletResponse response) throws Exception {
        log.info("进入魔蝎运营商认证异步回调。。。。。。");

        response.setStatus(201);
        PrintWriter writer = response.getWriter();
        writer.flush();
        writer.close();

        String mobile = (String) obj.get("mobile");
        String orderNo = (String) obj.get("user_id");
        String task_id = (String) obj.get("task_id");
        log.info("回调参数:mobile="+mobile+"&orderNo="+orderNo+"&task_id="+task_id);
        if(!StringUtils.isBlank(task_id)){
            OperatorReqLog operatorReqLog = null;
            if (StringUtils.isNotBlank(orderNo)) {
                operatorReqLog = operatorReqLogService.findSelective(orderNo);
            }
            if (operatorReqLog != null) {
                operatorReqLog.setRespOrderNo(task_id);
                // 紧急联系人认证（未添加）
                mxOperatorQuery(operatorReqLog,mobile);
            } else {
                log.error("回调参数:mobile="+mobile+"&orderNo="+orderNo+"&task_id="+task_id+",没有找到对应的operatorReqLog记录");
            }
        }
    }

    /**
     * 查询魔蝎运营商信息以及业务处理
     * @param operatorReqLog
     * @param
     */
    public  void  mxOperatorQuery(OperatorReqLog operatorReqLog,String mobiles){
        log.info("开始根据task_id="+operatorReqLog.getRespOrderNo()+"查询魔蝎运营商信息。。。。。。");
        Map<String, String> temp = new HashMap<String, String>();
        temp.put("taskId", operatorReqLog.getRespOrderNo());
        temp.put("mobiles", mobiles);
        temp.put("userId", operatorReqLog.getUserId().toString());
        JSONObject dataTemp = null;

        try {
            dataTemp = operatorReqLogService.mxOperatorQuery(temp);
        }catch (Exception e){
            e.printStackTrace();
        }
        HashMap<String,Object> params =new HashMap<String, Object>();
        params.put("userId",operatorReqLog.getUserId().toString());

        final Long userId = operatorReqLog.getUserId();
        final JSONObject finalDataTemp =dataTemp;
        UserAuth userAuth = new UserAuth();
        userAuth.setPhoneState(String.valueOf(30));
        userAuth.setPhoneStateTime(new Date());
        userAuthService.updateByPhoneState(userId);
        final OperatorReqLog log = operatorReqLog;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    operatorReqLogService.saveMXOperatorInfos(finalDataTemp,userId, log);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

}
