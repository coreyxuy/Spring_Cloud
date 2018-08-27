package com.toloan.pay.pojo;

import java.io.Serializable;

public class SysConfig implements Serializable {
    private static final long serialVersionUID = -4360301206505630418L;
    private Long id;

    private Byte type;

    private String name;

    private String code;

    private String value;

    private Boolean status;

    private String remark;

    private Integer creator;

    public SysConfig(Long id, Byte type, String name, String code, String value, Boolean status, String remark, Integer creator) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.code = code;
        this.value = value;
        this.status = status;
        this.remark = remark;
        this.creator = creator;
    }

    public SysConfig() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }
}