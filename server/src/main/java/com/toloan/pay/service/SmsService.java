package com.toloan.pay.service;

import com.toloan.pay.cache.Global;
import com.toloan.pay.enums.AppConstant;
import com.toloan.pay.enums.Constant;
import com.toloan.pay.exception.SimpleMessageException;
import com.toloan.pay.model.SmsModel;
import com.toloan.pay.pojo.Sms;
import com.toloan.pay.pojo.SmsTpl;
import com.toloan.pay.utils.DateUtil;
import com.toloan.pay.utils.RedisCommon;
import com.toloan.pay.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import net.sf.json.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.sf.json.xml.XMLSerializer;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Component
public class SmsService {

    public static final Logger logger = LoggerFactory.getLogger(SmsService.class);
    @Autowired
    private RedisService redisClient;

    @Resource
    private SmsTplService smsTplService;

    @Resource
    private SmsService smsService;
    @Autowired
    private RedisService redisService;


    private int msgcount;



    /**
     * 查找对于的短信模板
     * @param request
     * @param phone
     * @param type
     * @param params
     * @return
     */
    public String sendSmsByTpl(HttpServletRequest request, String phone, String type, Object... params) {
        SmsTpl smsTpl = getSmsTplFromRedis(type);
        if (smsTpl == null) {
            throw new SimpleMessageException("没有找到短信模板:" + type);
        }
        String templ = null;
        //只有启用的模版才发送短信
        if("10".equals(smsTpl.getState() )){
            templ= smsTpl.getTpl();
            for (int i = 0; i < params.length; i++) {
                Object value = params[i];
                if (value == null) {
                    value = "";
                } else {
                    value = value.toString();
                }
                templ = templ.replaceFirst("\\{}", (String) value);
            }
            sendSms(phone, type);
        }
        return templ;
    }



    public long sendSms(String phone, String type) {
        type = StringUtil.upperCase(type);
        SmsTpl tpl = smsService.getSmsTplFromRedis(type);
        if (tpl!=null && "10".equals(tpl.getState())) {
            int vcode = (int) (Math.random() * 9000) + 1000;
            String result = null;
            try {
                redisService.set(RedisCommon.SMS_REGISTER_CODE + phone, String.valueOf(vcode), 60 * 10);
                String messge = change(type).replaceAll("%s",vcode+"");
                logger.info("短信验证码为===================>"+vcode);
                result = sendCodeForLmobile(phone,messge);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return resultForLmobile(result, phone, type,vcode+"");
        }
        return 0;
    }




    /**
     * 短信验证
     * @param phone
     * @param type
     * @param vcode
     * @return
     */
    public String validateSmsCode(String phone, String type, String vcode) {
        if("dev".equals(Global.getValue("app_environment")) && "0000".equals(vcode)){
            return null;
        }

        Sms sms = getSmsFromRedis(phone,type);
        if (sms == null) {
            return "验证码已失效";
        }

        //限制只能发送10次
        int verifyTime = sms.getVerifyTime();     //sms.get("verify_time").toString();
        if (verifyTime>10) {
            return "验证码已失效";
        }

        //验证码的失效时间靠redis控制
        if (!vcode.equals(sms.getCode())) {
            return "验证码错误";
        }
        return null;
    }


    /**
     * 通联短信发送
     * @author pantheon
     * @since 20170713
     * @param mobile 手机号码
     * @param message 消息内容
     * @return
     */
    private String sendCodeForLmobile(String mobile, String message) throws UnsupportedEncodingException {
        logger.info("ClSmsServiceImpl-sendCodeForLmobile-发送手机号码-mobile："+mobile+"-短信内容为-"+message);
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(message)){
            logger.error("ClSmsServiceImpl-sendCodeForLmobile-传入参数错误-mobile："+mobile+"-message:"+message);
            return "";
        }
        String smsURL = Global.getValue("sms_apihost");//通联请求地址
        String account = Global.getValue("sms_account");// 用户名（必填）
        String password = Global.getValue("sms_account_pwd");// 密码（必填）
        String sign = Global.getValue("sms_sign"); // 短信签名（必填）

        String msg =    URLEncoder.encode(message,"UTF-8");

        String param = "sname="+account+"&spwd="+password+"&scorpid=&sprdid="+sign+"&sdst="+mobile+"&smsg=" +msg;
        return sendSMS(param, smsURL);
    }


    /**
     * 发送短信
     * @param postData
     * @param postUrl
     * @return
     */
    public String sendSMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);

            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                logger.debug("connect failed!");
                throw new RuntimeException("短信发送失败");
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            //e.printStackTrace(System.out);
            logger.debug("发送短信异常："+e);
            throw new RuntimeException("短信发送失败");
        }
    }


    /**
     * 获取sms模版
     * @param type
     * @return
     */
    public SmsTpl getSmsTplFromRedis(String type){
        type = StringUtils.upperCase(type);
        SmsTpl smsTpl = null;
        //查找该用用户的sms记录
        if( redisClient.exists(AppConstant.SMS_TEMPLATE+ type)){
            //因为sms模版会经常变动，为了在redis中可以方便更改所以smstpl在redis中定义为hash类型
            String typeName = redisClient.hget(AppConstant.SMS_TEMPLATE+ type,"type_name");
            String tpl = redisClient.hget(AppConstant.SMS_TEMPLATE+ type,"tpl");
            String number = redisClient.hget(AppConstant.SMS_TEMPLATE+ type,"number");
            String state = redisClient.hget(AppConstant.SMS_TEMPLATE+ type,"state");
            smsTpl = new SmsTpl();
            smsTpl.setType(type);
            smsTpl.setTpl(tpl);
            smsTpl.setNumber(number);
            smsTpl.setState(state);
            smsTpl.setTypeName(typeName);
        }else {
            logger.info("redis中失去了短信模板。从数据库请求短信模板再插入redis");
            SmsTpl tpl = smsTplService.getTpl(type);
            if(tpl != null){
                try{
                    redisClient.hset(AppConstant.SMS_TEMPLATE+ type,"type_name",tpl.getTypeName());
                    redisClient.hset(AppConstant.SMS_TEMPLATE+ type,"tpl",tpl.getTpl());
                    redisClient.hset(AppConstant.SMS_TEMPLATE+ type,"number",tpl.getNumber());
                    redisClient.hset(AppConstant.SMS_TEMPLATE+ type,"state",tpl.getState());
                }catch (Exception e){
                    logger.error("SmsService——>getSmsTplFromRedis——>"+ type +"：redis中没有数据，数据库查出后无法保存到redis中" + e );
                    e.printStackTrace();
                }
            }else {
                logger.error("SmsService——>getSmsTplFromRedis——>"+ type +":redis中没有数据并且数据库中也没有数据");
            }

            return tpl;
        }
        return smsTpl;
    }



    /**
     * 发送短信
     * @param result
     * @param phone
     * @param type
     * @param verCode
     * @return
     */
    private int resultForLmobile(String result,String phone,String type,String verCode){
        return resultForLmobile(result,phone,type,verCode,null);
    }

    private int resultForLmobile(String result,String phone,String type,String verCode,String borrowId){
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON json = xmlSerializer.read(result);
        JSONObject resultJsonTemp = JSONObject.parseObject(json.toString());
        if (StringUtil.isNotBlank(resultJsonTemp)) {
            logger.info("ClSmsServiceOmpl-resultForLmobile-返回参数:"+result);
            String dahanMsgId = StringUtil.isNull(resultJsonTemp.get("MsgID"));
            String dahanResult = StringUtil.isNull(resultJsonTemp.get("State"));
            String dahanDesc = StringUtil.isNull(resultJsonTemp.get("MsgState"));
            Sms sms = new Sms();
            sms.setPhone(phone);
            sms.setSendTime(DateUtil.getNow());
            sms.setContent(dahanDesc);
            sms.setRespTime(DateUtil.getNow());
            sms.setSmsType(type.toLowerCase());
            if(StringUtils.isNotBlank(verCode)){
                sms.setCode(verCode);
            }
            sms.setOrderNo(dahanMsgId);
            if ("0".equals(dahanResult)) {
                sms.setResp("短信已发送");
                sms.setState("10");
                msgcount = 1;
            }else{
                sms.setResp("短信发送失败");
                sms.setState("20");
                msgcount = 0;
            }
            sms.setVerifyTime(0);
            if(StringUtils.isBlank(borrowId)){
                smsService.saveSmsFromRedis(phone,type,sms);//该方法除了验证码相关的其它都是发送记录
            } else {
                smsService.saveSmsFromRedis(phone,type,sms,borrowId);//该方法除了验证码相关的其它都是发送记录
            }

        }else{
            logger.error("ClSmsServiceImpl-resultForLmobile:返回结果为空!"+"-phone:"+phone+"-type:"+type);
        }
        return msgcount;
    }




    public Sms getSmsFromRedis(String phone, String type){
        type = StringUtils.upperCase(type);
        String key = AppConstant.SMS_RECORD + type+":"+ phone;
        Sms sms = null;
        //查找该用用户的sms记录
        if( redisClient.exists(key)){
            sms = (Sms) redisClient.getObject( key);
        }
        return sms;
    }

    /**
     * 删除验证码
     * @param phone
     * @param type
     */
    public void delSmsFromRedis(String phone, String type){
        type = StringUtils.upperCase(type);
        String key = AppConstant.SMS_RECORD+type+":"+ phone;
        type = StringUtils.upperCase(type);
        Sms sms = null;
        //查找该用用户的sms记录
        if( redisClient.exists(key)){
            redisClient.delObject( key);
        }
    }


    /**
     * 获取某种类型短信发送的次数
     * @param phone
     * @param type
     * @return
     */
    public int getSmsCountFromRedis(String phone, String type){
        type = StringUtils.upperCase(type);
        int count = 0;
        String key = AppConstant.SMS_COUNT+type+":"+ phone;
        //该用户某种短信类型一天内调用次数（以第一次调用时间为起始）
        if( redisClient.exists(key)){
            String tempCount  = redisClient.get(key);
            if(!StringUtils.isBlank(tempCount)){
                count = Integer.parseInt(tempCount);
            }
        }
        return count;
    }

    /**
     * 更新或者插入每天验证码失效时间
     * @param phone
     * @param type
     * @return
     */
    public int updateAndSaveSmsCountFromRedis(String phone, String type){
        type = StringUtils.upperCase(type);
        int count = 1;
        String key = AppConstant.SMS_COUNT+type+":"+ phone;
        int smsTimeLimit =  getsmsTimeLimit();
        //该用户某种短信类型一天内调用次数（以第一次调用时间为起始）
        if( redisClient.exists(key)){
            long ttl = redisClient.ttl(key);
            long tempCount = redisClient.incr(key,smsTimeLimit-Integer.parseInt(ttl+""));
            count =  Integer.parseInt(tempCount+"");
        }else{
            redisClient.set(key,"1",smsTimeLimit);
            count = 1;
        }
        return count;
    }

    /**
     * 插入sms记录
     * @param phone
     * @param type
     * @param sms
     */
    public void saveSmsFromRedis(String phone, String type,Sms sms){
        type = StringUtils.upperCase(type);
        int smsTimeLimit =  getsmsTimeLimit();
        int verifyTime = 0;
        if(redisClient.exists(AppConstant.SMS_RECORD+type+":"+ phone)){
            Sms oldSms =(Sms)redisClient.getObject(AppConstant.SMS_RECORD+type+":"+ phone);
            verifyTime = oldSms.getVerifyTime()+1;
        }
        sms.setVerifyTime(verifyTime);
        if(SmsModel.SMS_TYPE_REGISTER.equals(type) || SmsModel.SMS_TYPE_FINDPAY.equals(type) || SmsModel.SMS_TYPE_FINDREG.equals(type)){
            //注册、找回登录密码、找回支付密码一般几分钟就失效了
            redisClient.setObject(AppConstant.SMS_RECORD+type+":"+ phone,sms,smsTimeLimit);
        }else { //非验证码类型短信
            int expireTime = Global.getInt("sms_record_expire_time"); //短信记录过期时间
            expireTime = expireTime*84600;  //一天84600秒
            redisClient.setObject(AppConstant.SMS_RECORD+type+":"+ phone,sms,expireTime);
        }


    }
    public void saveSmsFromRedis(String phone, String type,Sms sms,String  borrowId){
        type = StringUtils.upperCase(type);
        int smsTimeLimit =  getsmsTimeLimit();
        int verifyTime = 0;
        //20171010 丁力士 ":"+String.valueOf(borrowId)
        logger.info("判断redis中----是否包含短信内容"+"-phone:"+phone+"-type:"+type+"borrowId:"+borrowId);
        if(redisClient.exists(AppConstant.SMS_RECORD+type+":"+ phone+":"+String.valueOf(borrowId))){
            logger.info("redis中----包含短信内容"+"-phone:"+phone+"-type:"+type+"borrowId:"+borrowId);
            Sms oldSms =(Sms)redisClient.getObject(AppConstant.SMS_RECORD+type+":"+ phone+":"+borrowId);
            verifyTime = oldSms.getVerifyTime()+1;
        }
        sms.setVerifyTime(verifyTime);
        if(SmsModel.SMS_TYPE_REGISTER.equals(type) || SmsModel.SMS_TYPE_FINDPAY.equals(type) || SmsModel.SMS_TYPE_FINDREG.equals(type)){
            //注册、找回登录密码、找回支付密码一般几分钟就失效了
            redisClient.setObject(AppConstant.SMS_RECORD+type+":"+ phone+":"+borrowId,sms,smsTimeLimit);
        }else { //非验证码类型短信
            int expireTime = Global.getInt("sms_record_expire_time"); //短信记录过期时间
            expireTime = expireTime*84600;  //一天84600秒
            redisClient.setObject(AppConstant.SMS_RECORD+type+":"+ phone+":"+borrowId,sms,expireTime);
        }


    }


    /**
     * 添加sms模版
     * @param smsTpl
     * @return
     */
    public int addSmsTpl(SmsTpl smsTpl)throws SimpleMessageException{
        try {
            String type = StringUtils.upperCase(smsTpl.getType());
            redisClient.hset(AppConstant.SMS_TEMPLATE+ type,"type_name",smsTpl.getTypeName());
            redisClient.hset(AppConstant.SMS_TEMPLATE+ type,"tpl",smsTpl.getTpl());
            redisClient.hset(AppConstant.SMS_TEMPLATE+ type,"number",smsTpl.getNumber());
            redisClient.hset(AppConstant.SMS_TEMPLATE+ type,"state",smsTpl.getState());
        }catch (Exception e) {
            throw new SimpleMessageException( Constant.FAIL_CODE_VALUE,e.getMessage());
        }
        return 1;
    }

    /**
     * 删除sms模版
     * @param type
     * @return
     */
    public int delSmsTplFromRedis(String type)throws SimpleMessageException{
        try {
            String typeup = StringUtils.upperCase(type);
            redisClient.del(AppConstant.SMS_TEMPLATE+ typeup);

        }catch (Exception e) {
            throw new SimpleMessageException(Constant.FAIL_CODE_VALUE,e.getMessage());
        }
        return 1;
    }
    /**
     * 获取sms模版列表
     * @return List
     */
    public List<SmsTpl> getSmsTplFromRedisList(){
        Set keys =redisClient.keys("*");
        Object[] key =keys.toArray();

        List <SmsTpl>SmsTpllist = new ArrayList<SmsTpl>();
        for ( int i =0;i<key.length-1;i++){
            SmsTpl smsTpl = null;
            String tmp=key[i].toString();
            //查找该用用户的sms记录
            if( tmp.startsWith(AppConstant.SMS_TEMPLATE)){
                //因为sms模版会经常变动，为了在redis中可以方便更改所以smstpl在redis中定义为hash类型
                String typeName = redisClient.hget(tmp,"type_name");
                String tpl = redisClient.hget(tmp,"tpl");
                String number = redisClient.hget(tmp,"number");
                String state = redisClient.hget(tmp,"state");
                smsTpl = new SmsTpl();
                smsTpl.setId(i);
                smsTpl.setType(tmp.substring(13));
                smsTpl.setTpl(tpl);
                smsTpl.setNumber(number);
                smsTpl.setState(state);
                smsTpl.setTypeName(typeName);
                SmsTpllist.add(smsTpl);
            }
        }
        return SmsTpllist;
    }


    /**
     * 验证码失效时间
     * @return
     */
    public int getsmsTimeLimit(){
        int smsTimeLimit =  Global.getInt("sms_time_limit");
        if(smsTimeLimit == 0){
            smsTimeLimit = 300; //默认5分钟失效
        }else {
            smsTimeLimit = smsTimeLimit * 60;
        }
        return smsTimeLimit;
    }

    public String ret(String type){
        String tpl = null;
        SmsTpl smsTpl = smsService.getSmsTplFromRedis(type);
        if(smsTpl!=null && "10".equals( smsTpl.getState() )){
            tpl = smsTpl.getTpl();
        }
        return tpl;
    }


    public String change(String type){
        String message = null;
        if (SmsModel.SMS_TYPE_REGISTER.equals(type)) {
            message = ret(SmsModel.SMS_TYPE_REGISTER);
        }else if ( SmsModel.SMS_TYPE_FINDREG.equals(type)) {
            message = ret(SmsModel.SMS_TYPE_FINDREG);
        }else if (SmsModel.SMS_TYPE_BINDCARD.equals(type)) {
            message = ret(SmsModel.SMS_TYPE_BINDCARD);
        }else if (SmsModel.SMS_TYPE_FINDPAY.equals(type)) {
            message = ret(SmsModel.SMS_TYPE_FINDPAY);
        }else if (SmsModel.SMS_TYPE_OVERDUE.equals(type)) {
            message = ret(SmsModel.SMS_TYPE_OVERDUE);
        }else if (SmsModel.SMS_TYPE_LOANINFORM.equals(type)) {
            message = ret(SmsModel.SMS_TYPE_LOANINFORM);
        }else if (SmsModel.SMS_TYPE_REPAYINFORM.equals(type)) {
            message = ret(SmsModel.SMS_TYPE_REPAYINFORM);
        }else if (SmsModel.SMS_TYPE_REPAYBEFORE.equals(type)) {
            message = ret(SmsModel.SMS_TYPE_REPAYBEFORE);
        }else if (SmsModel.SMS_TYPE_REFUSE.equals(type)) {
            message = ret(SmsModel.SMS_TYPE_REFUSE);
        }
        return message;
    }
}
