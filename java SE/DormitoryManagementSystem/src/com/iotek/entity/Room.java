package com.iotek.entity;

import java.io.Serializable;

public class Room implements Serializable {
    private int buildId;
    private int roomId;
    private int bedNum;

    public Room() {
    }

    public Room(int buildId, int roomId, int bedNum) {
        this.buildId = buildId;
        this.roomId = roomId;
        this.bedNum = bedNum;
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

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    @Override
    public String toString() {
        return "宿舍楼号：" + buildId +" "+
                "房间号：" + roomId +" "+
                "床位数量：" + bedNum;
    }
}
