package com.iotek.entity;

import java.io.Serializable;
//报修记录
public class Repair implements Serializable {
    private int repairId;
    private int studentId;
    private int buildId;
    private int roomId;
    private String thingName;
    private int state = 0;//0.未休/1.已修

    public Repair() {

    }

    public Repair(int studentId, int buildId, int roomId, String thingName) {
        this.studentId = studentId;
        this.buildId = buildId;
        this.roomId = roomId;
        this.thingName = thingName;
    }

    public Repair(int studentId, int buildId, int roomId, String thingName, int state) {
        this.studentId = studentId;
        this.buildId = buildId;
        this.roomId = roomId;
        this.thingName = thingName;
        this.state = state;
    }

    public Repair(int repairId, int studentId, int buildId, int roomId, String thingName, int state) {
        this.repairId = repairId;
        this.studentId = studentId;
        this.buildId = buildId;
        this.roomId = roomId;
        this.thingName = thingName;
        this.state = state;
    }

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
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

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  "报修单号：" + repairId +" "+
                "学号：" + studentId +" "+
                "宿舍楼号：" + buildId +" "+
                "宿舍号：" + roomId +" "+
                "报修物品：" + thingName +" "+
                "修理状态：" + state;
    }
}
