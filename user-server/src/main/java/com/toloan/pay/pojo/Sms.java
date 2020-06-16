package com.toloan.pay.pojo;

import java.io.Serializable;
import java.util.Date;

public class Sms implements Serializable {
    private static final long serialVersionUID = 6620603796922139132L;
    private Long id;

    private String phone;

    private Date sendTime;

    private String content;

    private Date respTime;

    private String resp;

    private String smsType;

    private String code;

    private String orderNo;

    private String state;

    private Integer verifyTime;

    public Sms(Long id, String phone, Date sendTime, String content, Date respTime, String resp, String smsType, String code, String orderNo, String state, Integer verifyTime) {
        this.id = id;
        this.phone = phone;
        this.sendTime = sendTime;
        this.content = content;
        this.respTime = respTime;
        this.resp = resp;
        this.smsType = smsType;
        this.code = code;
        this.orderNo = orderNo;
        this.state = state;
        this.verifyTime = verifyTime;
    }

    public Sms() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getRespTime() {
        return respTime;
    }

    public void setRespTime(Date respTime) {
        this.respTime = respTime;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp == null ? null : resp.trim();
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType == null ? null : smsType.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Integer verifyTime) {
        this.verifyTime = verifyTime;
    }
}