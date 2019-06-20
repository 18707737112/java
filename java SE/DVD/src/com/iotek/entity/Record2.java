package com.iotek.entity;

public class Record2 {
    private int id;
    private int did;
    private String uname;
    private String dname;
    private String lendTime;
    private String returnTime;

    public Record2(String uname, String dname, String lendTime, String returnTime) {
        this.uname = uname;
        this.dname = dname;
        this.lendTime = lendTime;
        this.returnTime = returnTime;
    }

    public Record2(int id, int did, String uname, String dname, String lendTime, String returnTime) {
        this.id = id;
        this.did = did;
        this.uname = uname;
        this.dname = dname;
        this.lendTime = lendTime;
        this.returnTime = returnTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public String toString() {
        return "Record2{" +
                "id=" + id +
                ", did=" + did +
                ", uname='" + uname + '\'' +
                ", dname='" + dname + '\'' +
                ", lendTime='" + lendTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                '}';
    }
}
