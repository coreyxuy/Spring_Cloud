package com.toloan.pay.pojo;

import java.util.Date;

public class UserBaseInfo {
    private Long id;

    private Long userId;

    private String phone;

    private String realName;

    private Integer age;

    private String sex;

    private String national;

    private String idNo;

    private String idAddr;

    private String livingImg;

    private String ocrImg;

    private String frontImg;

    private String backImg;

    private String education;

    private String marryState;

    private String companyName;

    private String companyPhone;

    private String companyAddr;

    private String companyDetailAddr;

    private String companyCoordinate;

    private String salary;

    private String workingYears;

    private String workingImg;

    private String liveTime;

    private String liveAddr;

    private String liveDetailAddr;

    private String liveCoordinate;

    private String phoneServerPwd;

    private String registerAddr;

    private String registerCoordinate;

    private String state;

    private String blackReason;

    private Date updateTime;

    private Date createTime;

    private String livingImgHttp;

    private String backImgHttp;

    private String frontImgHttp;

    private String workingImgHttp;

    private String blackTime;

    public UserBaseInfo(Long id, Long userId, String phone, String realName, Integer age, String sex, String national, String idNo, String idAddr, String livingImg, String ocrImg, String frontImg, String backImg, String education, String marryState, String companyName, String companyPhone, String companyAddr, String companyDetailAddr, String companyCoordinate, String salary, String workingYears, String workingImg, String liveTime, String liveAddr, String liveDetailAddr, String liveCoordinate, String phoneServerPwd, String registerAddr, String registerCoordinate, String state, String blackReason, Date updateTime, Date createTime, String livingImgHttp, String backImgHttp, String frontImgHttp, String workingImgHttp, String blackTime) {
        this.id = id;
        this.userId = userId;
        this.phone = phone;
        this.realName = realName;
        this.age = age;
        this.sex = sex;
        this.national = national;
        this.idNo = idNo;
        this.idAddr = idAddr;
        this.livingImg = livingImg;
        this.ocrImg = ocrImg;
        this.frontImg = frontImg;
        this.backImg = backImg;
        this.education = education;
        this.marryState = marryState;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyAddr = companyAddr;
        this.companyDetailAddr = companyDetailAddr;
        this.companyCoordinate = companyCoordinate;
        this.salary = salary;
        this.workingYears = workingYears;
        this.workingImg = workingImg;
        this.liveTime = liveTime;
        this.liveAddr = liveAddr;
        this.liveDetailAddr = liveDetailAddr;
        this.liveCoordinate = liveCoordinate;
        this.phoneServerPwd = phoneServerPwd;
        this.registerAddr = registerAddr;
        this.registerCoordinate = registerCoordinate;
        this.state = state;
        this.blackReason = blackReason;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.livingImgHttp = livingImgHttp;
        this.backImgHttp = backImgHttp;
        this.frontImgHttp = frontImgHttp;
        this.workingImgHttp = workingImgHttp;
        this.blackTime = blackTime;
    }

    public UserBaseInfo() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national == null ? null : national.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getIdAddr() {
        return idAddr;
    }

    public void setIdAddr(String idAddr) {
        this.idAddr = idAddr == null ? null : idAddr.trim();
    }

    public String getLivingImg() {
        return livingImg;
    }

    public void setLivingImg(String livingImg) {
        this.livingImg = livingImg == null ? null : livingImg.trim();
    }

    public String getOcrImg() {
        return ocrImg;
    }

    public void setOcrImg(String ocrImg) {
        this.ocrImg = ocrImg == null ? null : ocrImg.trim();
    }

    public String getFrontImg() {
        return frontImg;
    }

    public void setFrontImg(String frontImg) {
        this.frontImg = frontImg == null ? null : frontImg.trim();
    }

    public String getBackImg() {
        return backImg;
    }

    public void setBackImg(String backImg) {
        this.backImg = backImg == null ? null : backImg.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState == null ? null : marryState.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone == null ? null : companyPhone.trim();
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public String getCompanyDetailAddr() {
        return companyDetailAddr;
    }

    public void setCompanyDetailAddr(String companyDetailAddr) {
        this.companyDetailAddr = companyDetailAddr == null ? null : companyDetailAddr.trim();
    }

    public String getCompanyCoordinate() {
        return companyCoordinate;
    }

    public void setCompanyCoordinate(String companyCoordinate) {
        this.companyCoordinate = companyCoordinate == null ? null : companyCoordinate.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(String workingYears) {
        this.workingYears = workingYears == null ? null : workingYears.trim();
    }

    public String getWorkingImg() {
        return workingImg;
    }

    public void setWorkingImg(String workingImg) {
        this.workingImg = workingImg == null ? null : workingImg.trim();
    }

    public String getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime == null ? null : liveTime.trim();
    }

    public String getLiveAddr() {
        return liveAddr;
    }

    public void setLiveAddr(String liveAddr) {
        this.liveAddr = liveAddr == null ? null : liveAddr.trim();
    }

    public String getLiveDetailAddr() {
        return liveDetailAddr;
    }

    public void setLiveDetailAddr(String liveDetailAddr) {
        this.liveDetailAddr = liveDetailAddr == null ? null : liveDetailAddr.trim();
    }

    public String getLiveCoordinate() {
        return liveCoordinate;
    }

    public void setLiveCoordinate(String liveCoordinate) {
        this.liveCoordinate = liveCoordinate == null ? null : liveCoordinate.trim();
    }

    public String getPhoneServerPwd() {
        return phoneServerPwd;
    }

    public void setPhoneServerPwd(String phoneServerPwd) {
        this.phoneServerPwd = phoneServerPwd == null ? null : phoneServerPwd.trim();
    }

    public String getRegisterAddr() {
        return registerAddr;
    }

    public void setRegisterAddr(String registerAddr) {
        this.registerAddr = registerAddr == null ? null : registerAddr.trim();
    }

    public String getRegisterCoordinate() {
        return registerCoordinate;
    }

    public void setRegisterCoordinate(String registerCoordinate) {
        this.registerCoordinate = registerCoordinate == null ? null : registerCoordinate.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getBlackReason() {
        return blackReason;
    }

    public void setBlackReason(String blackReason) {
        this.blackReason = blackReason == null ? null : blackReason.trim();
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

    public String getLivingImgHttp() {
        return livingImgHttp;
    }

    public void setLivingImgHttp(String livingImgHttp) {
        this.livingImgHttp = livingImgHttp == null ? null : livingImgHttp.trim();
    }

    public String getBackImgHttp() {
        return backImgHttp;
    }

    public void setBackImgHttp(String backImgHttp) {
        this.backImgHttp = backImgHttp == null ? null : backImgHttp.trim();
    }

    public String getFrontImgHttp() {
        return frontImgHttp;
    }

    public void setFrontImgHttp(String frontImgHttp) {
        this.frontImgHttp = frontImgHttp == null ? null : frontImgHttp.trim();
    }

    public String getWorkingImgHttp() {
        return workingImgHttp;
    }

    public void setWorkingImgHttp(String workingImgHttp) {
        this.workingImgHttp = workingImgHttp == null ? null : workingImgHttp.trim();
    }

    public String getBlackTime() {
        return blackTime;
    }

    public void setBlackTime(String blackTime) {
        this.blackTime = blackTime == null ? null : blackTime.trim();
    }
}