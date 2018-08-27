package com.toloan.pay.pojo;

import java.io.Serializable;

/**
 * 用户行为分析就是运营商消费数据实体
 *
 */
 public class CellBehavior implements Serializable {

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
    * 短信次数
    */
    private String smscnt;

    /**
    * 流量使用
    */
    private String netflow;

    /**
    * 消费金额
    */
    private String totalamount;

    /**
    * 月份
    */
    private String cellmth;

    /**
    * 归属地
    */
    private String cellloc;

    /**
    * 运营商
    */
    private String celloperatorZh;

    /**
    * 通话次数
    */
    private String callcnt;

    /**
    * 被叫时长
    */
    private String dialedtime;

    /**
    * 通话时长
    */
    private String rechangecnt;

    /**
    * 被叫次数
    */
    private String dialcnt;

    /**
    * 充值次数
    */
    private String rechangeCnt;

    /**
    * 充值总额
    */
    private String rechangeamount;


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
    * 获取短信次数
    *
    * @return 短信次数
    */
    public String getSmscnt(){
        return smscnt;
    }

    /**
    * 设置短信次数
    * 
    * @param smscnt 要设置的短信次数
    */
    public void setSmscnt(String smscnt){
        this.smscnt = smscnt;
    }

    /**
    * 获取流量使用
    *
    * @return 流量使用
    */
    public String getNetflow(){
        return netflow;
    }

    /**
    * 设置流量使用
    * 
    * @param netflow 要设置的流量使用
    */
    public void setNetflow(String netflow){
        this.netflow = netflow;
    }

    /**
    * 获取消费金额
    *
    * @return 消费金额
    */
    public String getTotalamount(){
        return totalamount;
    }

    /**
    * 设置消费金额
    * 
    * @param totalamount 要设置的消费金额
    */
    public void setTotalamount(String totalamount){
        this.totalamount = totalamount;
    }

    /**
    * 获取月份
    *
    * @return 月份
    */
    public String getCellmth(){
        return cellmth;
    }

    /**
    * 设置月份
    * 
    * @param cellmth 要设置的月份
    */
    public void setCellmth(String cellmth){
        this.cellmth = cellmth;
    }

    /**
    * 获取归属地
    *
    * @return 归属地
    */
    public String getCellloc(){
        return cellloc;
    }

    /**
    * 设置归属地
    * 
    * @param cellloc 要设置的归属地
    */
    public void setCellloc(String cellloc){
        this.cellloc = cellloc;
    }

    /**
    * 获取运营商
    *
    * @return 运营商
    */
    public String getCelloperatorZh(){
        return celloperatorZh;
    }

    /**
    * 设置运营商
    * 
    * @param celloperatorZh 要设置的运营商
    */
    public void setCelloperatorZh(String celloperatorZh){
        this.celloperatorZh = celloperatorZh;
    }

    /**
    * 获取通话次数
    *
    * @return 通话次数
    */
    public String getCallcnt(){
        return callcnt;
    }

    /**
    * 设置通话次数
    * 
    * @param callcnt 要设置的通话次数
    */
    public void setCallcnt(String callcnt){
        this.callcnt = callcnt;
    }

    /**
    * 获取被叫时长
    *
    * @return 被叫时长
    */
    public String getDialedtime(){
        return dialedtime;
    }

    /**
    * 设置被叫时长
    * 
    * @param dialedtime 要设置的被叫时长
    */
    public void setDialedtime(String dialedtime){
        this.dialedtime = dialedtime;
    }

    /**
    * 获取通话时长
    *
    * @return 通话时长
    */
    public String getRechangecnt(){
        return rechangecnt;
    }

    /**
    * 设置通话时长
    * 
    * @param rechangecnt 要设置的通话时长
    */
    public void setRechangecnt(String rechangecnt){
        this.rechangecnt = rechangecnt;
    }

    /**
    * 获取被叫次数
    *
    * @return 被叫次数
    */
    public String getDialcnt(){
        return dialcnt;
    }

    /**
    * 设置被叫次数
    * 
    * @param dialcnt 要设置的被叫次数
    */
    public void setDialcnt(String dialcnt){
        this.dialcnt = dialcnt;
    }

    /**
    * 获取充值次数
    *
    * @return 充值次数
    */
    public String getRechangeCnt(){
        return rechangeCnt;
    }

    /**
    * 设置充值次数
    * 
    * @param rechangeCnt 要设置的充值次数
    */
    public void setRechangeCnt(String rechangeCnt){
        this.rechangeCnt = rechangeCnt;
    }

    /**
    * 获取充值总额
    *
    * @return 充值总额
    */
    public String getRechangeamount(){
        return rechangeamount;
    }

    /**
    * 设置充值总额
    * 
    * @param rechangeamount 要设置的充值总额
    */
    public void setRechangeamount(String rechangeamount){
        this.rechangeamount = rechangeamount;
    }

}