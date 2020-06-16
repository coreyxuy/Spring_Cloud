package com.toloan.pay.pojo;

import java.io.Serializable;

/**
 * 用户行为监测实体
 *
 */
 public class MxCellBehaviorCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键Id
    */
    private Long id;

    /**
    * 同盾运营商通话详单
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
    * 号码使用时间
    */
    private String phoneusedtime;

    /**
    * 互通过电话的号码数量
    */
    private String contacteachother;

    /**
    * 与法院电话通话情况
    */
    private String contactcourt;

    /**
    * 与催收类号码联系情况
    */
    private String contactcollection;

    /**
    * 号码通话情况（phone_call）
    */
    private String phonecall;


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
    * 获取同盾运营商通话详单
    *
    * @return 同盾运营商通话详单
    */
    public Long getUserId(){
        return userId;
    }

    /**
    * 设置同盾运营商通话详单
    * 
    * @param userId 要设置的同盾运营商通话详单
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
    * 获取号码使用时间
    *
    * @return 号码使用时间
    */
    public String getPhoneusedtime(){
        return phoneusedtime;
    }

    /**
    * 设置号码使用时间
    * 
    * @param phoneusedtime 要设置的号码使用时间
    */
    public void setPhoneusedtime(String phoneusedtime){
        this.phoneusedtime = phoneusedtime;
    }

    /**
    * 获取互通过电话的号码数量
    *
    * @return 互通过电话的号码数量
    */
    public String getContacteachother(){
        return contacteachother;
    }

    /**
    * 设置互通过电话的号码数量
    * 
    * @param contacteachother 要设置的互通过电话的号码数量
    */
    public void setContacteachother(String contacteachother){
        this.contacteachother = contacteachother;
    }

    /**
    * 获取与法院电话通话情况
    *
    * @return 与法院电话通话情况
    */
    public String getContactcourt(){
        return contactcourt;
    }

    /**
    * 设置与法院电话通话情况
    * 
    * @param contactcourt 要设置的与法院电话通话情况
    */
    public void setContactcourt(String contactcourt){
        this.contactcourt = contactcourt;
    }

    /**
    * 获取与催收类号码联系情况
    *
    * @return 与催收类号码联系情况
    */
    public String getContactcollection(){
        return contactcollection;
    }

    /**
    * 设置与催收类号码联系情况
    * 
    * @param contactcollection 要设置的与催收类号码联系情况
    */
    public void setContactcollection(String contactcollection){
        this.contactcollection = contactcollection;
    }

    /**
    * 获取号码通话情况（phone_call）
    *
    * @return 号码通话情况（phone_call）
    */
    public String getPhonecall(){
        return phonecall;
    }

    /**
    * 设置号码通话情况（phone_call）
    * 
    * @param phonecall 要设置的号码通话情况（phone_call）
    */
    public void setPhonecall(String phonecall){
        this.phonecall = phonecall;
    }

}