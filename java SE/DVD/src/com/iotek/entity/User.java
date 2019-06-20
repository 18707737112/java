package com.iotek.entity;

import java.io.Serializable;

// 照抄
public class User implements Serializable{
    private int id;
    private String uname;
    private String upass;
    private int type; // 用户类型

    public User() {
    }

    // 存入文件时，不知道ID，需要自增
    public User(String uname, String upass, int type) {
        this.uname = uname;
        this.upass = upass;
        this.type = type;
    }

    // 取出数据时，是带ID的
    public User(int id, String uname, String upass, int type) {
        this.id = id;
        this.uname = uname;
        this.upass = upass;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", type=" + type +
                '}';
    }
}
