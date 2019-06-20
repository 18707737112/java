package com.iotek.zy5_30.hw1;

public class Student implements ISwich{
    private String name;
    private int age;
    public Student(String name,int age){ this.name=name;this.age=age; }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String detail(){
        return "你好,我的名字叫:"+name+",今年:"+age+"岁";
    }
}
