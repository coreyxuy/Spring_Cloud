package com.toloan.pay.pojo;

import java.io.Serializable;

/**
 * 运营商报告表实体
 * 
 * @author pantheon
 * @version 1.0.0
 * @date 2017-11-04 11:25:30
 * Copyright 杭州民华金融信息服务有限公司  cashloan All Rights Reserved
 * 官方网站：www.yongqianbei.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
 public class MxBasic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键Id
    */
    private Long id;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 请求记录id
    */
    private Long reqLogId;

    /**
    * 请求订单号
    */
    private String orderNo;

    /**
    * 报告id
    */
    private String taskId;

    /**
    * 渠道数据源  中国移动中国联通中国电信
    */
    private String sourcenamezh;

    /**
    * 报报告生成时间
    */
    private String updatetime;

    /**
    * 报告手机号
    */
    private String mobile;

    /**
    * 用户名
    */
    private String carriername;

    /**
    * 入网时间
    */
    private String regtime;

    /**
    * 入网时长
    */
    private Long intime;

    /**
    * 是否实名认证
    */
    private String reliability;

    /**
    * 手机号归属地
    */
    private String phoneattribution;

    /**
    * 通话记录完整性
    */
    private String calldatacheck;

    /**
    * 姓名是否与通话记录匹配
    */
    private String namematch;

    /**
    * 是否出现在法院黑名单
    */
    private String isnameandidcardinfinanceblack;

    /**
    * 是否出现在金融机构黑名单
    */
    private String isnameandmobileinfinanceblack;

    /**
    * 联系人一号码
    */
    private String phoneNum;

    /**
    * 联系人一名字
    */
    private String contactName;


    /**
    * 联系人一号码归属地
    */
    private String phoneNumLoc;

    /**
    * 联系人一通话次数
    */
    private Long callCnt;

    /**
    * 联系人二号码
    */
    private String phoneNum2;

    /**
    * 联系人二名字
    */
    private String contactName2;

    /**
    * 联系人二关系
    */
    private String relationship2;

    /**
     * 联系人关系
     */
    private String relation;


    /**
    * 联系人二号码归属地
    */
    private String phoneNumLoc2;

    /**
    * 联系人二通话次数
    */
    private Long callCnt2;

    /**
    * 联系人一和联系人二通话总次数
    */
    private Long callCntCount;

    /**
    * 联系人状态
    */
    private Long callCntState;

    /**
    * 用户号码联系黑中介分数（分数范围0-100，参考分为10，分数越低关系越紧密）
    */
    private Long phonegrayscore;

   /**
    * 联系人一号码
    */
   private String phone;

   /**
    * 联系人一名字
    */
   private String name;

   /**
    * 联系人一关系
    */
   private String type;

   /**
    * 联系人一关系
    */
   private String relationship;

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
    * 获取主键Id
    *
    * @return id
    */
    public Long getId(){
        return id;
    }

    /**
    * 设置主键Id
    * 
    * @param 要设置的主键Id
    */
    public void setId(Long id){
        this.id = id;
    }

    /**
    * 获取用户id
    *
    * @return 用户id
    */
    public Long getUserId(){
        return userId;
    }

    /**
    * 设置用户id
    * 
    * @param userId 要设置的用户id
    */
    public void setUserId(Long userId){
        this.userId = userId;
    }

    /**
    * 获取请求记录id
    *
    * @return 请求记录id
    */
    public Long getReqLogId(){
        return reqLogId;
    }

    /**
    * 设置请求记录id
    * 
    * @param reqLogId 要设置的请求记录id
    */
    public void setReqLogId(Long reqLogId){
        this.reqLogId = reqLogId;
    }

    /**
    * 获取请求订单号
    *
    * @return 请求订单号
    */
    public String getOrderNo(){
        return orderNo;
    }

    /**
    * 设置请求订单号
    * 
    * @param orderNo 要设置的请求订单号
    */
    public void setOrderNo(String orderNo){
        this.orderNo = orderNo;
    }

    /**
    * 获取报告id
    *
    * @return 报告id
    */
    public String getTaskId(){
        return taskId;
    }

    /**
    * 设置报告id
    * 
    * @param taskId 要设置的报告id
    */
    public void setTaskId(String taskId){
        this.taskId = taskId;
    }

    /**
    * 获取渠道数据源  中国移动中国联通中国电信
    *
    * @return 渠道数据源  中国移动中国联通中国电信
    */
    public String getSourcenamezh(){
        return sourcenamezh;
    }

    /**
    * 设置渠道数据源  中国移动中国联通中国电信
    * 
    * @param sourcenamezh 要设置的渠道数据源  中国移动中国联通中国电信
    */
    public void setSourcenamezh(String sourcenamezh){
        this.sourcenamezh = sourcenamezh;
    }

    /**
    * 获取报报告生成时间
    *
    * @return 报报告生成时间
    */
    public String getUpdatetime(){
        return updatetime;
    }

    /**
    * 设置报报告生成时间
    * 
    * @param updatetime 要设置的报报告生成时间
    */
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }

    /**
    * 获取报告手机号
    *
    * @return 报告手机号
    */
    public String getMobile(){
        return mobile;
    }

    /**
    * 设置报告手机号
    * 
    * @param mobile 要设置的报告手机号
    */
    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    /**
    * 获取用户名
    *
    * @return 用户名
    */
    public String getCarriername(){
        return carriername;
    }

    /**
    * 设置用户名
    * 
    * @param carriername 要设置的用户名
    */
    public void setCarriername(String carriername){
        this.carriername = carriername;
    }

    /**
    * 获取入网时间
    *
    * @return 入网时间
    */
    public String getRegtime(){
        return regtime;
    }

    /**
    * 设置入网时间
    * 
    * @param regtime 要设置的入网时间
    */
    public void setRegtime(String regtime){
        this.regtime = regtime;
    }

    /**
    * 获取入网时长
    *
    * @return 入网时长
    */
    public Long getIntime(){
        return intime;
    }

    /**
    * 设置入网时长
    * 
    * @param intime 要设置的入网时长
    */
    public void setIntime(Long intime){
        this.intime = intime;
    }

    /**
    * 获取是否实名认证
    *
    * @return 是否实名认证
    */
    public String getReliability(){
        return reliability;
    }

    /**
    * 设置是否实名认证
    * 
    * @param reliability 要设置的是否实名认证
    */
    public void setReliability(String reliability){
        this.reliability = reliability;
    }

    /**
    * 获取手机号归属地
    *
    * @return 手机号归属地
    */
    public String getPhoneattribution(){
        return phoneattribution;
    }

    /**
    * 设置手机号归属地
    * 
    * @param phoneattribution 要设置的手机号归属地
    */
    public void setPhoneattribution(String phoneattribution){
        this.phoneattribution = phoneattribution;
    }

    /**
    * 获取通话记录完整性
    *
    * @return 通话记录完整性
    */
    public String getCalldatacheck(){
        return calldatacheck;
    }

    /**
    * 设置通话记录完整性
    * 
    * @param calldatacheck 要设置的通话记录完整性
    */
    public void setCalldatacheck(String calldatacheck){
        this.calldatacheck = calldatacheck;
    }

    /**
    * 获取姓名是否与通话记录匹配
    *
    * @return 姓名是否与通话记录匹配
    */
    public String getNamematch(){
        return namematch;
    }

    /**
    * 设置姓名是否与通话记录匹配
    * 
    * @param namematch 要设置的姓名是否与通话记录匹配
    */
    public void setNamematch(String namematch){
        this.namematch = namematch;
    }

    /**
    * 获取是否出现在法院黑名单
    *
    * @return 是否出现在法院黑名单
    */
    public String getIsnameandidcardinfinanceblack(){
        return isnameandidcardinfinanceblack;
    }

    /**
    * 设置是否出现在法院黑名单
    * 
    * @param isnameandidcardinfinanceblack 要设置的是否出现在法院黑名单
    */
    public void setIsnameandidcardinfinanceblack(String isnameandidcardinfinanceblack){
        this.isnameandidcardinfinanceblack = isnameandidcardinfinanceblack;
    }

    /**
    * 获取是否出现在金融机构黑名单
    *
    * @return 是否出现在金融机构黑名单
    */
    public String getIsnameandmobileinfinanceblack(){
        return isnameandmobileinfinanceblack;
    }

    /**
    * 设置是否出现在金融机构黑名单
    * 
    * @param isnameandmobileinfinanceblack 要设置的是否出现在金融机构黑名单
    */
    public void setIsnameandmobileinfinanceblack(String isnameandmobileinfinanceblack){
        this.isnameandmobileinfinanceblack = isnameandmobileinfinanceblack;
    }

    /**
    * 获取联系人一号码
    *
    * @return 联系人一号码
    */
    public String getPhoneNum(){
        return phoneNum;
    }

    /**
    * 设置联系人一号码
    * 
    * @param phoneNum 要设置的联系人一号码
    */
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    /**
    * 获取联系人一名字
    *
    * @return 联系人一名字
    */
    public String getContactName(){
        return contactName;
    }

    /**
    * 设置联系人一名字
    * 
    * @param contactName 要设置的联系人一名字
    */
    public void setContactName(String contactName){
        this.contactName = contactName;
    }

    /**
    * 获取联系人一关系
    *
    * @return 联系人一关系
    */
    public String getRelationship(){
        return relationship;
    }

    /**
    * 设置联系人一关系
    * 
    * @param relationship 要设置的联系人一关系
    */
    public void setRelationship(String relationship){
        this.relationship = relationship;
    }

    /**
    * 获取联系人一号码归属地
    *
    * @return 联系人一号码归属地
    */
    public String getPhoneNumLoc(){
        return phoneNumLoc;
    }

    /**
    * 设置联系人一号码归属地
    * 
    * @param phoneNumLoc 要设置的联系人一号码归属地
    */
    public void setPhoneNumLoc(String phoneNumLoc){
        this.phoneNumLoc = phoneNumLoc;
    }

    /**
    * 获取联系人一通话次数
    *
    * @return 联系人一通话次数
    */
    public Long getCallCnt(){
        return callCnt;
    }

    /**
    * 设置联系人一通话次数
    * 
    * @param callCnt 要设置的联系人一通话次数
    */
    public void setCallCnt(Long callCnt){
        this.callCnt = callCnt;
    }

    /**
    * 获取联系人二号码
    *
    * @return 联系人二号码
    */
    public String getPhoneNum2(){
        return phoneNum2;
    }

    /**
    * 设置联系人二号码
    * 
    * @param phoneNum2 要设置的联系人二号码
    */
    public void setPhoneNum2(String phoneNum2){
        this.phoneNum2 = phoneNum2;
    }

    /**
    * 获取联系人二名字
    *
    * @return 联系人二名字
    */
    public String getContactName2(){
        return contactName2;
    }

    /**
    * 设置联系人二名字
    * 
    * @param contactName2 要设置的联系人二名字
    */
    public void setContactName2(String contactName2){
        this.contactName2 = contactName2;
    }

    /**
    * 获取联系人二关系
    *
    * @return 联系人二关系
    */
    public String getRelationship2(){
        return relationship2;
    }

    /**
    * 设置联系人二关系
    * 
    * @param relationship2 要设置的联系人二关系
    */
    public void setRelationship2(String relationship2){
        this.relationship2 = relationship2;
    }

    /**
    * 获取联系人二号码归属地
    *
    * @return 联系人二号码归属地
    */
    public String getPhoneNumLoc2(){
        return phoneNumLoc2;
    }

    /**
    * 设置联系人二号码归属地
    * 
    * @param phoneNumLoc2 要设置的联系人二号码归属地
    */
    public void setPhoneNumLoc2(String phoneNumLoc2){
        this.phoneNumLoc2 = phoneNumLoc2;
    }

    /**
    * 获取联系人二通话次数
    *
    * @return 联系人二通话次数
    */
    public Long getCallCnt2(){
        return callCnt2;
    }

    /**
    * 设置联系人二通话次数
    * 
    * @param callCnt2 要设置的联系人二通话次数
    */
    public void setCallCnt2(Long callCnt2){
        this.callCnt2 = callCnt2;
    }

    /**
    * 获取联系人一和联系人二通话总次数
    *
    * @return 联系人一和联系人二通话总次数
    */
    public Long getCallCntCount(){
        return callCntCount;
    }

    /**
    * 设置联系人一和联系人二通话总次数
    * 
    * @param callCntCount 要设置的联系人一和联系人二通话总次数
    */
    public void setCallCntCount(Long callCntCount){
        this.callCntCount = callCntCount;
    }

    /**
    * 获取联系人状态
    *
    * @return 联系人状态
    */
    public Long getCallCntState(){
        return callCntState;
    }

    /**
    * 设置联系人状态
    * 
    * @param callCntState 要设置的联系人状态
    */
    public void setCallCntState(Long callCntState){
        this.callCntState = callCntState;
    }

    /**
    * 获取用户号码联系黑中介分数（分数范围0-100，参考分为10，分数越低关系越紧密）
    *
    * @return 用户号码联系黑中介分数（分数范围0-100，参考分为10，分数越低关系越紧密）
    */
    public Long getPhonegrayscore(){
        return phonegrayscore;
    }

    /**
    * 设置用户号码联系黑中介分数（分数范围0-100，参考分为10，分数越低关系越紧密）
    * 
    * @param phonegrayscore 要设置的用户号码联系黑中介分数（分数范围0-100，参考分为10，分数越低关系越紧密）
    */
    public void setPhonegrayscore(Long phonegrayscore){
        this.phonegrayscore = phonegrayscore;
    }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }
}