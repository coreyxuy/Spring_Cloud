package com.toloan.response;

/**
 * Created by geely
 */
public enum ResponseCode {

    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR"),
    SESSION_EXIT(300,"会话失效"),
    NEED_LOGIN(100,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(300,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
