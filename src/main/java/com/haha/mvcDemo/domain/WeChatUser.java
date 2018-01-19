package com.haha.mvcDemo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class WeChatUser implements Serializable {
    private Integer openId;

    private String unionId;

    private BigDecimal money;

    private String username;

    private static final long serialVersionUID = 1L;

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}