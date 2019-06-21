package com.iotek.entity;

import java.io.Serializable;

public class Bed implements Serializable {
    private int buildId;
    private int roomId;
    private int bedId;
    private int studentId = 0;

    public Bed() {
    }

    public Bed(int buildId, int roomId, int bedId) {
        this.buildId = buildId;
        this.roomId = roomId;
        this.bedId = bedId;
    }

    public Bed(int buildId, int roomId, int bedId, int studentId) {
        this.buildId = buildId;
        this.roomId = roomId;
        this.bedId = bedId;
        this.studentId = studentId;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "宿舍楼号：" + buildId +" "+
                "房间号：" + roomId +" "+
                "床位号：" + bedId +" "+
                "状态：" + studentId;
    }
}
