package com.toloan.pay.enums;


public class AppConstant {

    /**
     * session相关
     */
    //通过phone_num可以找到ticket_data
    public static final String REDIS_KEY_LOGIN_PHONE_FOR_TICKETDATA = "APP_LOGIN:TICKET:PHONE_FOR_TICKETDATA_";

    //通过ticketId找到ticket_data
    public static final String REDIS_KEY_LOGIN_TICKETID_FOR_TICKETDATA = "APP_LOGIN:TICKETID:TICKET_FOR_TICKETDATA_";

    //用户是否被锁定
    public static final int USER_STATUS_NORMAL = 1;
    public static final int USER_STATUS_FOBID = 2;


    /**
     *  短信相关
     */
    public static final String SMS_TEMPLATE = "SMS:TEMPLATE:";  //短信模版,如：SMS:TEMPLATE:FINDPAY
    public static final String SMS_RECORD = "SMS:RECORD:";      //短信记录，如：SMS:RECORD:REGISTER:18658821091
    public static final String SMS_COUNT = "SMS:COUNT:";        //记录用户一天某种类型短信的请求次数(从第一次该类型短信发送起开始计数)，如SMS:COUNT:REGISTER:18658821091
    public static final String SMS_REGISTER_COUNT = "SMS:REGISTER:COUNT:";  //注册短信一天只能发送3次

    /**
     *  10分钟内只能借款一次
     */
    public static final String BORROW_INBORROW = "BORROW:INBORROW:";

    /**
     *  当日最大借款次数
     */
    public static final String BORROW_DAY_TIMES = "BORROW:DAY_TIMES:";



    /**
     *  报表相关
     */
    public static final String STATIS_WORKBENCH = "STATIS:WORKBENCH";   //工作台缓存


    /**
     *  APK下载相关
     */
    public static final String APK_DOWNLOAD = "APK:DOWNLOAD:";


    /**
     *  CODE获取流量平台链接的地址
     */
    public static final String FLOW_PALTFORM_HTTP = "FLOW:PALTFORM:HTTP:";

    /**
     *  CODE获取点击流量平台链接的数量
     */
    public static final String FLOW_PALTFORM_AMOUNT = "FLOW:PALTFORM:AMOUNT:";
    /**
     *  用户多少天后可以再试
     */
    public static final String FLOW_PALTFORM_DAY = "FLOW:PALTFORM:DAY:";
    /**
     *  用户多少小时后可以再试
     */
    public static final String FLOW_PALTFORM_HOUR= "FLOW:PALTFORM:HOUR:";
    /**
     *  获取H5平台页面
     */
    public static final String FLOW_PALTFORM_H5 = "http://h5.yongqianbei.com/other.html";

    /**
     *  微信相关
     */
    // 用户微信账户信息在redis中的键值
    public static final String REDIS_KEY_WX_LOGIN_TICKET = "APP_LOGIN_WX:WX_TICKET:TICKET_";

    //ACCESS_TOKEN在redis中的键值
    public static final String REDIS_KEY_WX_LOGIN_TOKEN = "APP_LOGIN_WX:WX_ACCESS_TOKEN:ACCESS_TOKEN_";

    //登录手机验证码(不能用hset,会一起失效的)
    public static final String REDIS_KEY_MOBILE_LOGIN_CHECKCODE = "APP_LOGIN_PHONE:PHONE_CHECKCODE:PHONE_CHECKCODE_";

    //手机注册验证码(不能用hset,会一起失效的)
    public static final String REDIS_KEY_MOBILE_REGISTER_CHECKCODE = "APP_REGISTER_PHONE:PHONE_CHECKCODE:PHONE_CHECKCODE_";


    //每天实名认证统一个IP只能20次
    public static final String REDIS_KEY_LOCK_REALNAME_IP = "LOCK:REALNAME:IP_";

    //每天实名认证统一个手机号只能20次
    public static final String REDIS_KEY_LOCK_REALNAME_MOBILE = "LOCK:REALNAME:MOBILE_";

    //每天短信验证码一个IP只能20次
    public static final String REDIS_KEY_LOCK_CHECKCODE_IP = "LOCK:CHECKCODE:IP_";

    //每天短信验证码一个手机号只能20次
    public static final String REDIS_KEY_LOCK_CHECKCODE_MOBILE = "LOCK:CHECKCODE:MOBILE_";

    //每分钟短信验证码一个手机号只能发送一次
    public static final String REDIS_KEY_LOCK_CHECKCODE_MINUTE_MOBILE = "LOCK:CHECKCODE_MINUTE:MOBILE_";

    //加入计划的锁判断，身份证纬度
    public static final String REDIS_KEY_LOCK_SAVEORDERFUNDS_CARDID = "LOCK:SAVEORDERFUNDS:CARDID:";

    //加入计划的锁判断，手机号纬度
    public static final String REDIS_KEY_LOCK_SAVEORDERFUNDS_MOBILE = "LOCK:SAVEORDERFUNDS:MOBILE:";


    /**
     *  防止借款过于频繁(10分钟内只能申请一次)
     */
    public static final String REDIS_KEY_LOCK_BORROW_REQUENTLY = "LOCK:BORROW_REQUENTLY_";

    /**
     *  防止借款过于频繁(10分钟内只能申请一次)
     */
    public static final String REDIS_KEY_LOCK_SMS_REQUENTLY = "LOCK:SMS_REQUENTLY_";


    /**
     * 借款时分布式锁
     */
    public static final String REDIS_KEY_LOCK_BORROW= "LOCK:BORROW_";


    /**
     *  邀请码id自加锁
     */
    public static final String REDIS_KEY_LOCK_INVITE_ID= "LOCK:INVITE_ID";




    /**
     * H5导流锁
     */
    public static final String REDIS_KEY_LOCK_FLOW= "LOCK:FLOW_";
    /**
     * 站岗资金锁key
     * @author pantheon
     * @since 20170926
     */
    public static final String REDIS_KEY_LOCK_SENTRYFUNDS = "LOCK:SENTRYFUNDS";

    /**
     * 站岗资金放款剩余次数
     * @author pantheon
     * @since 20170926
     */
    public static final String REDIS_KEY_TIMES_SENTRYFUNDSLOAN = "TIMES:SENTRYFUNDSLOAN";

    /**
     * CallInfo表ID锁key
     */
    public static final String REDIS_KEY_LOCK_CALLINFO = "LOCK:CALLINFO";

    /**
     * CallInfo表ID值
     */
    public static final String REDIS_KEY_TIMES_CALLINFOID = "TIMES:CALLINFOID";

    /**
     *  邀请码id
     */
    public static final String REDIS_KEY_TIMES_INVITE_ID= "TIMES:INVITE_ID";




    /**
     *  风控：新借用户和复借用户可以配置时间和次数,redis中放置的为List。YONGQB-161
     */
    public static final String REDIS_KEY_RISK_USERBORROW = "RISK:USERBORROW";

    /**
     * 推送消息mq的app参数
     */
    public static  final String pushNotificationRedisMQ="PUSH:NOTIFICATION:APP:MQ";

    /**
     * 测试一分钱锁
     */
    public static final String TEST_PAY_REDIS_LOCK = "TEST:PAY_LOCK:";

    public static final String TEST_PAY_REDIS = "TEST:PAY:";

}
