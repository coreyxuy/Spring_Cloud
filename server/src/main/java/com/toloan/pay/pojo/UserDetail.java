package com.toloan.pay.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserDetail implements Serializable {
    private static final long serialVersionUID = -217536385012756455L;
    private Long id;

    private String phone;

    private Long userId;

    private String realName;

    private String idNo;

    private String qq;

    private String wechat;

    private String amount;

    private String zhima;

    private Date createTime;

    private Date updateTime;

    public UserDetail(Long id, String phone, Long userId, String realName, String idNo, String qq, String wechat, String amount, String zhima, Date createTime, Date updateTime) {
        this.id = id;
        this.phone = phone;
        this.userId = userId;
        this.realName = realName;
        this.idNo = idNo;
        this.qq = qq;
        this.wechat = wechat;
        this.amount = amount;
        this.zhima = zhima;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserDetail() {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getZhima() {
        return zhima;
    }

    public void setZhima(String zhima) {
        this.zhima = zhima == null ? null : zhima.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}