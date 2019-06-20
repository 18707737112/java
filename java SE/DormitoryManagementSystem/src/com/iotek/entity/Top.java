package com.iotek.entity;

import java.io.Serializable;
import java.util.Date;

public class Top implements Serializable {
    private int studentId;
    private double amount;
    private Date date;

    public Top() {
    }

    public Top(int studentId, double amount) {
        this.studentId = studentId;
        this.amount = amount;
    }

    public Top(int studentId, double amount, Date date) {
        this.studentId = studentId;
        this.amount = amount;
        this.date = date;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "学号：" + studentId +" "+
                "充值金额：" + amount +" "+
                "充值时间：" + date;
    }
}
