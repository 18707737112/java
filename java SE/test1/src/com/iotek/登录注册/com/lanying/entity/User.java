package com.iotek.登录注册.com.lanying.entity;

import java.io.Serializable;
// 因为想通过对象流将User写入文件，所以User必须可序列化
public class User implements Serializable {
    private int id;
    private String uname;
    private String upass;// 密码
    private int type; // 管理员 or 普通用户

    public User() {
    }

    public User(String uname, String upass, int type) {
        this.uname = uname;
        this.upass = upass;
        this.type = type;
    }

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
