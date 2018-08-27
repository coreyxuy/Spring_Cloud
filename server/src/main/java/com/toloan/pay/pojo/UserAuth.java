package com.toloan.pay.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserAuth implements Serializable {

    private static final long serialVersionUID = -4306916339630106713L;
    private Long id;

    private Long userId;

    private String idState;

    private Date idStateTime;

    private String qqState;

    private Date qqStateTime;

    private String zhimaState;

    private Date zhimaStateTime;

    private String phoneState;

    private Date phoneStateTime;

    private String taobaoState;

    private Date taobaoStateTime;

    private Byte newVersion;

    public UserAuth(Long id, Long userId, String idState, Date idStateTime, String qqState, Date qqStateTime, String zhimaState, Date zhimaStateTime, String phoneState, Date phoneStateTime, String taobaoState, Date taobaoStateTime, Byte newVersion) {
        this.id = id;
        this.userId = userId;
        this.idState = idState;
        this.idStateTime = idStateTime;
        this.qqState = qqState;
        this.qqStateTime = qqStateTime;
        this.zhimaState = zhimaState;
        this.zhimaStateTime = zhimaStateTime;
        this.phoneState = phoneState;
        this.phoneStateTime = phoneStateTime;
        this.taobaoState = taobaoState;
        this.taobaoStateTime = taobaoStateTime;
        this.newVersion = newVersion;
    }

    public UserAuth() {
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

    public String getIdState() {
        return idState;
    }

    public void setIdState(String idState) {
        this.idState = idState == null ? null : idState.trim();
    }

    public Date getIdStateTime() {
        return idStateTime;
    }

    public void setIdStateTime(Date idStateTime) {
        this.idStateTime = idStateTime;
    }

    public String getQqState() {
        return qqState;
    }

    public void setQqState(String qqState) {
        this.qqState = qqState == null ? null : qqState.trim();
    }

    public Date getQqStateTime() {
        return qqStateTime;
    }

    public void setQqStateTime(Date qqStateTime) {
        this.qqStateTime = qqStateTime;
    }

    public String getZhimaState() {
        return zhimaState;
    }

    public void setZhimaState(String zhimaState) {
        this.zhimaState = zhimaState == null ? null : zhimaState.trim();
    }

    public Date getZhimaStateTime() {
        return zhimaStateTime;
    }

    public void setZhimaStateTime(Date zhimaStateTime) {
        this.zhimaStateTime = zhimaStateTime;
    }

    public String getPhoneState() {
        return phoneState;
    }

    public void setPhoneState(String phoneState) {
        this.phoneState = phoneState == null ? null : phoneState.trim();
    }

    public Date getPhoneStateTime() {
        return phoneStateTime;
    }

    public void setPhoneStateTime(Date phoneStateTime) {
        this.phoneStateTime = phoneStateTime;
    }

    public String getTaobaoState() {
        return taobaoState;
    }

    public void setTaobaoState(String taobaoState) {
        this.taobaoState = taobaoState == null ? null : taobaoState.trim();
    }

    public Date getTaobaoStateTime() {
        return taobaoStateTime;
    }

    public void setTaobaoStateTime(Date taobaoStateTime) {
        this.taobaoStateTime = taobaoStateTime;
    }

    public Byte getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(Byte newVersion) {
        this.newVersion = newVersion;
    }
}