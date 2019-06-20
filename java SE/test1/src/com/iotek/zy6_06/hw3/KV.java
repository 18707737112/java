package com.iotek.zy6_06.hw3;

public class KV implements Comparable<KV>{
    private int id; // 字符
    private Student student; // 出现的次数

    public KV(int id, Student student) {
        this.id = id;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /*@Override // List中的contains方法调用的就是元素自身的equals方法
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KV kv = (KV) o;

        return c == kv.c;
    }*/

    @Override
    public String toString() {
        return id +"-"+ student;
    }

    @Override
    public int compareTo(KV o) {
        if(this.student.getScore() - o.student.getScore() > 0){
            return -1;
        }else if(this.student.getScore() - o.student.getScore() < 0){
            return 1;
        }else{
            return student.getName().compareTo(o.student.getName());
        }
    }
}