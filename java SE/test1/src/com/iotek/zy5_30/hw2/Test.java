package com.iotek.zy5_30.hw2;

/*
给定“stuId,name,age”格式的学生信息，通过解析字符串，创建学生对象，
要求：
必须有私有化，构造方法重载，set get方法，重写toString方法，
并且在main方法中调用。
* */
public class Test {
    public static void main(String[] args) {
        String s = "199507小明24";
        int stuId = Integer.parseInt(s.substring(0,6));
        String name = s.substring(6,8);
        int age = Integer.parseInt(s.substring(8,10));
        Student student = new Student();
        student.setStuId(stuId);
        student.setName(name);
        student.setAge(age);
        System.out.println(student.getStuId());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.toString());
    }
}
