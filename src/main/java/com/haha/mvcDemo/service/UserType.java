package com.haha.mvcDemo.service;

/**
 * Created by gaige on 2018/1/19.
 */
public enum UserType {

    //1，微信注册的用户
    //2，普通电话注册的用户
    WeChatUser(1),PhoneUser(2);

    private int value;
    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
