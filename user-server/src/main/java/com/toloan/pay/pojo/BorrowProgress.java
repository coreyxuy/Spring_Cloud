package com.toloan.pay.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ：Corey
 * 19:53 2018/8/20
 */
public class BorrowProgress implements Serializable {

    private Long id;

    private Long userId;

    private String status;

    private String channelCode;

    private Date createTime;

    private Date updateTime;

    public BorrowProgress(Long id, Long userId, String status, String channelCode, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.channelCode = channelCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BorrowProgress() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
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
