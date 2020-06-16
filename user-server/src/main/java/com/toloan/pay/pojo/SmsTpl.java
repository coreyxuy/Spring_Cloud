package com.toloan.pay.pojo;

import java.io.Serializable;

public class SmsTpl implements Serializable {
    private static final long serialVersionUID = 3918227133046144629L;
    private Integer id;

    private String type;

    private String typeName;

    private String tpl;

    private String number;

    private String state;

    public SmsTpl(Integer id, String type, String typeName, String tpl, String number, String state) {
        this.id = id;
        this.type = type;
        this.typeName = typeName;
        this.tpl = tpl;
        this.number = number;
        this.state = state;
    }

    public SmsTpl() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTpl() {
        return tpl;
    }

    public void setTpl(String tpl) {
        this.tpl = tpl == null ? null : tpl.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}