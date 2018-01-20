package com.haha.mvcDemo.service;

/**
 * Created by gaige on 2018/1/20.
 */
public enum GetUserStatus {
    //重复添加
    ADD_USER_FAILED(-1);
    private int value;

    GetUserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
