package com.iotek.entity;

import java.io.Serializable;

public class Dormitory implements Serializable {
    private int buildId;//宿舍楼号
    private String personSex;
    private int roomNum;//宿舍数量

    public Dormitory() {
    }

    public Dormitory(String personSex, int roomNum) {
        this.personSex = personSex;
        this.roomNum = roomNum;
    }

    public Dormitory(int buildId, String personSex, int roomNum) {
        this.buildId = buildId;
        this.personSex = personSex;
        this.roomNum = roomNum;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    @Override
    public String toString() {
        return "宿舍楼号：" + buildId +" "+
                "人员性别：'" + personSex +" "+
                "房间数量：" + roomNum;
    }
}
