package com.toloan.pay.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ：Corey
 * 20:43 2018/8/20
 * 管理员用户登录
 */
public class SystemUser implements Serializable {
    private static final long serialVersionUID = 657799102785769043L;

    private Long id;

    private String admin;

    private String password;

    private Date createTime;

    private Date updateTime;

    public SystemUser(Long id, String admin, String password, Date createTime, Date updateTime) {
        this.id = id;
        this.admin = admin;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SystemUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin == null ? null : admin.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
