package com.toloan.pay.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PayLog {
    private Long id;

    private String orderNo;

    private Long userId;

    private Long borrowId;

    private BigDecimal amount;

    private String cardNo;

    private String bank;

    private String confirmCode;

    private String source;

    private String type;

    private String scenes;

    private String state;

    private String remark;

    private Date payReqTime;

    private Date updateTime;

    private Date createTime;

    public PayLog(Long id, String orderNo, Long userId, Long borrowId, BigDecimal amount, String cardNo, String bank, String confirmCode, String source, String type, String scenes, String state, String remark, Date payReqTime, Date updateTime, Date createTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.userId = userId;
        this.borrowId = borrowId;
        this.amount = amount;
        this.cardNo = cardNo;
        this.bank = bank;
        this.confirmCode = confirmCode;
        this.source = source;
        this.type = type;
        this.scenes = scenes;
        this.state = state;
        this.remark = remark;
        this.payReqTime = payReqTime;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public PayLog() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode == null ? null : confirmCode.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getScenes() {
        return scenes;
    }

    public void setScenes(String scenes) {
        this.scenes = scenes == null ? null : scenes.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getPayReqTime() {
        return payReqTime;
    }

    public void setPayReqTime(Date payReqTime) {
        this.payReqTime = payReqTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}