package com.iotek.entity;

import java.io.Serializable;
//迁入/迁出记录
public class Check implements Serializable {
    private int checkId;//迁入/迁出单号
    private int studentId;//学号
    private int type = 1;//1.授权/0.迁出

    public Check() {
    }

    public Check(int studentId) {
        this.studentId = studentId;
    }

    public Check(int studentId, int type) {
        this.studentId = studentId;
        this.type = type;
    }

    public Check(int checkId, int studentId, int type) {
        this.checkId = checkId;
        this.studentId = studentId;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "授权/迁出单号：" + checkId +" "+
                "学号：" + studentId +" "+
                "类型：" + type;
    }
}
