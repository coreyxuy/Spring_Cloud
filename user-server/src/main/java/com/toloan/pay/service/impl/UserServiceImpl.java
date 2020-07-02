package com.toloan.pay.service.impl;

import com.toloan.pay.cache.Global;
import com.toloan.pay.exception.SimpleMessageException;
import com.toloan.pay.mapper.*;
import com.toloan.pay.pojo.BorrowProgress;
import com.toloan.pay.pojo.User;
import com.toloan.pay.pojo.UserAuth;
import com.toloan.pay.pojo.UserDetail;
import com.toloan.pay.service.RedisService;
import com.toloan.pay.service.UserService;
import com.toloan.pay.utils.HttpClientUtil;
import com.toloan.pay.utils.MD5Utils;
import com.toloan.pay.utils.RedisCommon;
import com.toloan.pay.utils.RegexUtils;
import com.toloan.response.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.alibaba.druid.util.Utils.md5;


@Service(value = "UserService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;
    @Autowired
    private UserAuthMapper userAuthMapper;
    @Autowired
    private UserDetailMapper userDetailMapper;
    @Autowired
    private BorrowProgressMapper borrowProgressMapper;
    @Autowired
    private ChannelUserMapper channelUserMapper;


    /**
     * 用户注册
     * @param request
     * @param phone
     * @param loginPwd
     * @param vcode
     * @param client
     * @param channelCode
     * @return
     */
    @Override
    public ServerResponse registerUser(HttpServletRequest request, final String phone, final String loginPwd, String vcode, String client, final String channelCode) {
        if (!StringUtils.isNumeric(phone) || !RegexUtils.checkMobile(phone) || StringUtils.isEmpty(loginPwd) || StringUtils.isEmpty(vcode)) {
            return ServerResponse.createByErrorMessage("参数有误！");
        }
        //判断手机号是否注册
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("phone",phone);
        params.put("channel",channelCode);
        int i = userMapper.countPhone(params);
        if (i>0){
            return ServerResponse.createByErrorMessage("当前手机号已经注册,请点击登录！");
        }
        //判断是否存在渠道
        int channelUserCode = channelUserMapper.getChannelUserCode(channelCode);
        if (channelUserCode == 0 && channelCode != null){
            return ServerResponse.createByErrorMessage("渠道信息有误！");
        }
        String code = redisService.get(RedisCommon.SMS_REGISTER_CODE + phone);
        if (StringUtils.isBlank(code)){
            return ServerResponse.createByErrorMessage("验证码失效！");
        }
        if(!StringUtils.equals(vcode,code)){
            return ServerResponse.createByErrorMessage("验证码不正确！");
        }
        User user = new User();
        String solt = RandomStringUtils.randomAlphabetic(6);
        user.setPhone(phone);
        user.setPassword(loginPwd);
        user.setClient(3);
        user.setChannel(channelCode);
        user.setSolt(solt);
        userMapper.insertSelective(user);
        UserDetail userDetail = new UserDetail();
        userDetail.setPhone(user.getPhone());
        userDetail.setUserId(user.getId()); //set用户id
        userDetail.setCreateTime(new Date());
        userDetailMapper.insertSelective(userDetail);
        //插入用户认证表
        UserAuth userAuth = new UserAuth();
        userAuth.setUserId(user.getId());
        userAuth.setIdState("10");
        userAuth.setIdStateTime(new Date());
        userAuth.setZhimaState("10");
        userAuth.setZhimaStateTime(new Date());
        userAuth.setQqState("10");
        userAuth.setQqStateTime(new Date());
        userAuth.setTaobaoState("10");
        userAuth.setTaobaoStateTime(new Date());
        userAuthMapper.insert(userAuth);
        BorrowProgress borrowProgress = new BorrowProgress();
        borrowProgress.setUserId(user.getId());
        borrowProgress.setChannelCode(channelCode);
        borrowProgress.setCreateTime(new Date());
        borrowProgressMapper.insert(borrowProgress);
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //蓝带平台导流
                    Map<String,Object> map = new HashMap<String, Object>();
                    int mobileType = 4;
                    String url = Global.getValue("Lend_You_Money");
                    String DIVERSION_KEY = "dsQjAfSFwkBCv@*+17fdg8h3iqinIUWDC81*&asdFaGvVsF";
                    String signMsg = md5(phone + loginPwd + channelCode + mobileType + DIVERSION_KEY); //验签
                    map.put("loginName",phone);
                    map.put("loginPwd",loginPwd);
                    map.put("channelCode",channelCode);
                    map.put("signMsg",signMsg);
                    map.put("mobileType",mobileType);
                    HttpClientUtil.postForm(url,map);
                    redisService.del(RedisCommon.SMS_REGISTER_CODE + phone);
                }
            });
            thread.start();
        }catch (Exception e){
            log.error("UserService-->registerUser：数据传送至“贷你有钱”平台异常，" + e );
        }
        return ServerResponse.createBySuccess();
    }





    /**
     * 登陆
     * 2018/8/14
     *
     * @param request
     * @param loginName
     * @param loginPwd
     * @return
     */
    @Override
    public ServerResponse login(HttpServletRequest request, String loginName, String loginPwd , String channelCode) {
        //校验
        if (!RegexUtils.checkMobile(loginName)){
            throw new SimpleMessageException("手机格式不正确");
        }
        Map<String,Object> paremt = new HashMap<String, Object>();
        paremt.put("loginName",loginName);
        paremt.put("channelCode",channelCode);
        User user = userMapper.getUserByMobile(paremt);
        if (user == null){
            return ServerResponse.createByErrorMessage("用戶不存在！");
        }
        if (!StringUtils.equalsIgnoreCase(loginPwd,user.getPassword())){
            return ServerResponse.createByErrorMessage("密码不正确");
        }else {
            String sign = UUID.randomUUID().toString();
            Long s1 = user.getId();
            String userId = String.valueOf(s1);
            user.setSolt(null);
            user.setPassword(null);
            String s = redisService.setObject(sign, user, 30  * 60 * 60);//一天
            log.info(s);
            Map<String,Object> map = new  HashMap();
            map.put("sign",sign);
            map.put("userId",userId);
            return ServerResponse.createBySuccess("登陆成功！",map);
        }

    }





    @Override
    public ServerResponse postMobileCode(String mobile) {
        //校验
        if (!RegexUtils.checkMobile(mobile)){
            return ServerResponse.createByErrorMessage("手机号格式错误,请确认之后重新输入");
        }
        String old = redisService.get(mobile);
        if (StringUtils.isNotBlank(old)){
            return ServerResponse.createByErrorMessage("操作频繁请稍后再试！");
        }
        //生成6个随机数字
        String code = RandomStringUtils.randomNumeric(6);
        redisService.set(mobile,code,60*10);
        //发送短信
        //smsService.sendSms();
        return ServerResponse.createBySuccess(code);
    }

    @Override
    public User getChannelCode(Long userId, String channelCode) {
        return userMapper.getChannelCode(userId,channelCode);
    }

    @Override
    public User getPhone(Long userId) {
        return userMapper.getPhone(userId);
    }

    @Override
    public User findById(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
