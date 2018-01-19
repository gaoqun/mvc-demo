package com.haha.mvcDemo.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gaige on 2017/12/8.
 */
public class UserVo {
    private String userName;
    private String userId;
    private String telephone;
    private String nickName;
    private BigDecimal money;
    private Date createTime;

    public UserVo() {
    }

    public UserVo(String userId,String userName, String telephone,BigDecimal money,Date createTime) {
        this.userName = userName;
        this.userId = userId;
        this.telephone = telephone;
        this.money = money;
        this.createTime = createTime;
    }

    public UserVo(String userId, String username, BigDecimal money) {
        this.userId = userId;
        this.userName = username;
        this.money = money;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
