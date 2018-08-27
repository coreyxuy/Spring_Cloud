package com.toloan.pay.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 渠道号及对应转化率表实体
 * 
 * @author JJH
 * @version 1.0.0
 * @date 2018-08-16 23:05:03
 */
 public class ChannelSwitch implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键Id
    */
    private Long id;

    /**
    * 渠道号
    */
    private String channelId;

    /**
    * 开关，10开，20关闭
    */
    private String switchs;

    /**
    * 渠道名称
    */
    private String channelName;

    /**
    * 注册转化率
    */
    private Double registerRate;

    /**
    * 认证转化率（相对注册转化）
    */
    private Double authRate;

    /**
    * 借款转化率（相对认证转化）
    */
    private Double borrowRate;

    /**
    * 放款转化率（相对借款转化）
    */
    private Double loanRate;

    /**
     * 商户密码
     */
    private  String password;

    /**
    * 创建时间
    */
    @JsonFormat( pattern = "yyyy-MM-dd" , timezone = " GMT+8 " )
    private Date createTime;


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
    * @param id 要设置的主键Id
    */
    public void setId(Long id){
        this.id = id;
    }

    /**
    * 获取渠道号
    *
    * @return 渠道号
    */
    public String getChannelId(){
        return channelId;
    }

    /**
    * 设置渠道号
    * 
    * @param channelId 要设置的渠道号
    */
    public void setChannelId(String channelId){
        this.channelId = channelId;
    }

    /**
    * 获取开关，10开，20关闭
    *
    * @return 开关，10开，20关闭
    */
    public String getSwitchs(){
        return switchs;
    }

    /**
    * 设置开关，10开，20关闭
    * 
    * @param switchs 要设置的开关，10开，20关闭
    */
    public void setSwitchs(String switchs){
        this.switchs = switchs;
    }

    /**
    * 获取渠道名称
    *
    * @return 渠道名称
    */
    public String getChannelName(){
        return channelName;
    }

    /**
    * 设置渠道名称
    * 
    * @param channelName 要设置的渠道名称
    */
    public void setChannelName(String channelName){
        this.channelName = channelName;
    }

    /**
    * 获取注册转化率
    *
    * @return 注册转化率
    */
    public Double getRegisterRate(){
        return registerRate;
    }

    /**
    * 设置注册转化率
    * 
    * @param registerRate 要设置的注册转化率
    */
    public void setRegisterRate(Double registerRate){
        this.registerRate = registerRate;
    }

    /**
    * 获取认证转化率（相对注册转化）
    *
    * @return 认证转化率（相对注册转化）
    */
    public Double getAuthRate(){
        return authRate;
    }

    /**
    * 设置认证转化率（相对注册转化）
    * 
    * @param authRate 要设置的认证转化率（相对注册转化）
    */
    public void setAuthRate(Double authRate){
        this.authRate = authRate;
    }

    /**
    * 获取借款转化率（相对认证转化）
    *
    * @return 借款转化率（相对认证转化）
    */
    public Double getBorrowRate(){
        return borrowRate;
    }

    /**
    * 设置借款转化率（相对认证转化）
    * 
    * @param borrowRate 要设置的借款转化率（相对认证转化）
    */
    public void setBorrowRate(Double borrowRate){
        this.borrowRate = borrowRate;
    }

    /**
    * 获取放款转化率（相对借款转化）
    *
    * @return 放款转化率（相对借款转化）
    */
    public Double getLoanRate(){
        return loanRate;
    }

    /**
    * 设置放款转化率（相对借款转化）
    * 
    * @param loanRate 要设置的放款转化率（相对借款转化）
    */
    public void setLoanRate(Double loanRate){
        this.loanRate = loanRate;
    }

    /**
    * 获取创建时间
    *
    * @return 创建时间
    */
    public Date getCreateTime(){
        return createTime;
    }

    /**
    * 设置创建时间
    * 
    * @param createTime 要设置的创建时间
    */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}