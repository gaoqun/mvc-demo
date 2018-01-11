package com.haha.mvcDemo.vo;

/**
 * Created by gaige on 2017/12/8.
 */
public class UserVo {
    private String userName;
    private String userId;
    private String telephone;
    private String nickName;

    public UserVo() {
    }

    public UserVo(String userId,String userName, String telephone, String nickName) {
        this.userName = userName;
        this.userId = userId;
        this.telephone = telephone;
        this.nickName = nickName;
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
}
