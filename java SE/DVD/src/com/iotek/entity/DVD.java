package com.iotek.entity; // 实体类，即各种各样的对象（一般情况下，一个类对应数据库中的一张表）

import java.io.Serializable;

public class DVD implements Serializable {
    private int id;
    private String dname;
    private int dcount;
    private int status; // 1可借 0不可借

    public DVD() {
    }

    public DVD(String dname, int dcount, int status) {
        this.dname = dname;
        this.dcount = dcount;
        this.status = status;
    }

    public DVD(int id, String dname, int dcount, int status) {
        this.id = id;
        this.dname = dname;
        this.dcount = dcount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getDcount() {
        return dcount;
    }

    public void setDcount(int dcount) {
        this.dcount = dcount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", dcount=" + dcount +
                ", status=" + status +
                '}';
    }
}
