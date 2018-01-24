package com.haha.mvcDemo.domain;

import com.haha.mvcDemo.utils.DateUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String userName;

    private String pwd;

    private Date createTime;

    private String telephone;

    private String nickName;

    private BigDecimal money;

    private Integer openId;

    private Integer combineAccountFlag;

    private String combineAccountTime;

    public String getCombineAccountTime() {
        return combineAccountTime;
    }

    public void setCombineAccountTime(Date combineAccountTime) {
            this.combineAccountTime = DateUtil.f.format(combineAccountTime);
    }

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public Integer getCombineAccountFlag() {
        return combineAccountFlag;
    }

    public void setCombineAccountFlag(Integer combineAccountFlag) {
        this.combineAccountFlag = combineAccountFlag;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}