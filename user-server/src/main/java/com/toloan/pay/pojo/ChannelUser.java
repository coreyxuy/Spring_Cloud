package com.toloan.pay.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台用户信息表
 */
public class ChannelUser implements Serializable {

    private static final long serialVersionUID = -1876837712786448985L;
    private Long id;

    private String name;

    private String loginName;

    private String password;

    private Date updateTime;

    private Date createTime;

    public ChannelUser(Long id, String name, String loginName, String password, Date updateTime, Date createTime) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public ChannelUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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