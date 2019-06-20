package com.iotek.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private int studentId;
    private String studentName;
    private String sex;

    public Student() {
    }

    public Student(String studentName, String sex) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.sex = sex;
    }

    public Student(int studentId, String studentName, String sex) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.sex = sex;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "学号：" + studentId +" "+
                "姓名：" + studentName +" "+
                "性别：" + sex;
    }
}
