package com.iotek.entity;

import java.io.Serializable;
//迁入/迁出记录
public class Check implements Serializable {
    private int checkId;//迁入/迁出单号
    private int studentId;
    private int buildId;
    private int roomId;
    private int bedId;
    private int type;

    public Check() {
    }

    public Check(int studentId, int buildId, int roomId, int bedId, int type) {
        this.studentId = studentId;
        this.buildId = buildId;
        this.roomId = roomId;
        this.bedId = bedId;
        this.type = type;
    }

    public Check(int checkId, int studentId, int buildId, int roomId, int bedId, int type) {
        this.checkId = checkId;
        this.studentId = studentId;
        this.buildId = buildId;
        this.roomId = roomId;
        this.bedId = bedId;
        this.type = type;
    }

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "迁入/迁出单号：" + checkId +" "+
                "学号：" + studentId +" "+
                "宿舍楼号：" + buildId +" "+
                "宿舍号：" + roomId +" "+
                "床位号：" + bedId +" "+
                "类型：" + type;
    }
}
