package com.toloan.pay.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;

/**
 * 渠道每日数据记录表实体
 * 
 * @author JJH
 * @version 1.0.0
 * @date 2018-08-16 23:04:29
 */
 public class ChannelLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 渠道号码
     */
    private String channelId;

    /**
     * 注册数
     */
    private Integer registerNum;

    /**
     * 认证数
     */
    private Integer authNum;

    /**
     * 申请数
     */
    private Integer borrowNum;

    /**
     * 放款数
     */
    private Integer loanNum;

    /**
     * 创建时间
     */
    @JsonFormat ( pattern = "yyyy-MM-dd HH:mm:ss" , timezone = " GMT+8 " )
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat ( pattern = "yyyy-MM-dd HH:mm:ss" , timezone = " GMT+8 " )
    private Date updateTime;


    /**
     * 获取主键Id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键Id
     *
     * @param 要设置的主键Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取渠道号码
     *
     * @return 渠道号码
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道号码
     *
     * @param channelId 要设置的渠道号码
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取注册数
     *
     * @return 注册数
     */
    public Integer getRegisterNum() {
        return registerNum;
    }

    /**
     * 设置注册数
     *
     * @param registerNum 要设置的注册数
     */
    public void setRegisterNum(Integer registerNum) {
        this.registerNum = registerNum;
    }

    /**
     * 获取认证数
     *
     * @return 认证数
     */
    public Integer getAuthNum() {
        return authNum;
    }

    /**
     * 设置认证数
     *
     * @param authNum 要设置的认证数
     */
    public void setAuthNum(Integer authNum) {
        this.authNum = authNum;
    }

    /**
     * 获取申请数
     *
     * @return 申请数
     */
    public Integer getBorrowNum() {
        return borrowNum;
    }

    /**
     * 设置申请数
     *
     * @param borrowNum 要设置的申请数
     */
    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
    }

    /**
     * 获取放款数
     *
     * @return 放款数
     */
    public Integer getLoanNum() {
        return loanNum;
    }

    /**
     * 设置放款数
     *
     * @param loanNum 要设置的放款数
     */
    public void setLoanNum(Integer loanNum) {
        this.loanNum = loanNum;
    }

    /**
     * 获取创建时间
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 要设置的创建时间
     */
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