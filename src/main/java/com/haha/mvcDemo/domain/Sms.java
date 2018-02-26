package com.haha.mvcDemo.domain;

public class Sms {
    private String to;
    private String msg;

    public Sms() {
    }

    public Sms(String to, String msg) {
        this.to = to;
        this.msg = msg;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "to='" + to + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
