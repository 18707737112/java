package com.iotek.entity;

import java.io.Serializable;

public class StudentCard implements Serializable {
    private int studentId;
    private String studetName;
    private String password;
    private String sex;
    private double money;

    public StudentCard() {
    }

    public StudentCard(int studentId, String password) {
        this.studentId = studentId;
        this.password = password;
    }

    public StudentCard(int studentId, String studetName, String password, String sex, double money) {
        this.studentId = studentId;
        this.studetName = studetName;
        this.password = password;
        this.sex = sex;
        this.money = money;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudetName() {
        return studetName;
    }

    public void setStudetName(String studetName) {
        this.studetName = studetName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "学生卡：：" +
                "学号：" + studentId + " " +
                "姓名：" + studetName + " " +
                "密码：" + password + " " +
                "性别：" + sex + " " +
                "余额：" + money;
    }
}
