package com.haha.mvcDemo.utils.java8Lambda;

import java.util.List;
import java.util.Map;

public class TestUser {

    private Map<String, String> map;
    private String username;
    private String password;
    private String sex;
    private List<String> tags;

    public TestUser() {
    }

    public TestUser(Map<String,String> map) {
        this.map = map;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public TestUser(String username, String password, String sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", tags=" + tags +
                '}';
    }
}
