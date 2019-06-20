package com.iotek.zy5_30.hw1;

public class Book implements ISwich {
    private String name;
    private int num;
    public Book() {
    }
    public Book(String name, int num) { this.name = name;this.num = num; }
    public void setName(String name) {
        this.name = name;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public int getNum() {
        return num;
    }
    @Override
    public String detail() {
        return "课程："+name+",课时："+num;
    }
}
