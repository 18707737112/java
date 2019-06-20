package com.iotek.zy6_06.hw3;
/*
要求如下：
1）创建Student类，包含String类型的name，int类型的age，double类型的score，
    并重写getter、setter等方法。
2）创建5个Student对象。键是Integer类型的学号，值是Student对象。
3）将5个Student对象保存到HashMap容器中。
4）遍历该容器，打印到控制台上。（直接println不得分）
*/

public class Student{
    private String name;
    private int age;
    private double score;

    public Student() {
    }

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
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
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + "-" + age + "-" + score;
    }
}
