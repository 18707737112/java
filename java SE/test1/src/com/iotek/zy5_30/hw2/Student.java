package com.iotek.zy5_30.hw2;

public class Student {
    private int stuId;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int stuId, String name, int age) {
        this.stuId = stuId;
        this.name = name;
        this.age = age;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
