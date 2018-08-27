package com.toloan.pay.pojo;

import java.io.Serializable;

/**
 * 魔蝎的通话详单实体
 *
 */
 public class MxCallRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键Id
    */
    private Long id;

    /**
    * 通话记录id
    */
    private Long userId;

    /**
    * 最后一次通话时间
    */
    private String transend;

    /**
    * 号码
    */
    private String peernum;

    /**
    * 需求类型
    */
    private String groupname;

    /**
    * 互联网标识
    */
    private String companyname;

    /**
    * 归属地
    */
    private String city;

    /**
    * 近六个月通话次数(分)
    */
    private Integer callcnt6m;


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
    * 获取通话记录id
    *
    * @return 通话记录id
    */
    public Long getUserId(){
        return userId;
    }

    /**
    * 设置通话记录id
    * 
    * @param infoId 要设置的通话记录id
    */
    public void setUserId(Long infoId){
        this.userId = infoId;
    }

    /**
    * 获取最后一次通话时间
    *
    * @return 最后一次通话时间
    */
    public String getTransend(){
        return transend;
    }

    /**
    * 设置最后一次通话时间
    * 
    * @param transend 要设置的最后一次通话时间
    */
    public void setTransend(String transend){
        this.transend = transend;
    }

    /**
    * 获取号码
    *
    * @return 号码
    */
    public String getPeernum(){
        return peernum;
    }

    /**
    * 设置号码
    * 
    * @param peernum 要设置的号码
    */
    public void setPeernum(String peernum){
        this.peernum = peernum;
    }

    /**
    * 获取需求类型
    *
    * @return 需求类型
    */
    public String getGroupname(){
        return groupname;
    }

    /**
    * 设置需求类型
    * 
    * @param groupname 要设置的需求类型
    */
    public void setGroupname(String groupname){
        this.groupname = groupname;
    }

    /**
    * 获取互联网标识
    *
    * @return 互联网标识
    */
    public String getCompanyname(){
        return companyname;
    }

    /**
    * 设置互联网标识
    * 
    * @param companyname 要设置的互联网标识
    */
    public void setCompanyname(String companyname){
        this.companyname = companyname;
    }

    /**
    * 获取归属地
    *
    * @return 归属地
    */
    public String getCity(){
        return city;
    }

    /**
    * 设置归属地
    * 
    * @param city 要设置的归属地
    */
    public void setCity(String city){
        this.city = city;
    }

    /**
    * 获取近六个月通话次数(分)
    *
    * @return 近六个月通话次数(分)
    */
    public Integer getCallcnt6m(){
        return callcnt6m;
    }

    /**
    * 设置近六个月通话次数(分)
    * 
    * @param callcnt6m 要设置的近六个月通话次数(分)
    */
    public void setCallcnt6m(Integer callcnt6m){
        this.callcnt6m = callcnt6m;
    }

}