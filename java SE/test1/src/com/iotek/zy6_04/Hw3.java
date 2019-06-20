package com.iotek.zy6_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
使用listIterator获取学生对象
 在迭代器中添加一个学号为4，名字叫 a 成绩为99的学生
 遍历，删除 学号为4的学生，
 修改学号为5的学员的name 为 666
*/
public class Hw3 {
    public static void main(String[] args) {
        List<Student> list = new LinkedList<>();
        list.add(new Student(5,"eee",90));
        list.add(new Student(6,"fff",100));
        list.add(new Student(7,"ggg",95));
        list.add(new Student(8,"hhh",94));
        list.add(new Student(9,"iii",98));
        ListIterator<Student> it = list.listIterator();
        it.add(new Student(4,"a",99));
        it = list.listIterator();
        Student student = null;
        while (it.hasNext()){
            student = it.next();
            System.out.println(student);
            if (student.getId()==4){
                it.remove();
            }
            if (student.getId()==5){
                student.setName("666");
            }
        }
        System.out.println("------------------------");
        it = list.listIterator();
        while (it.hasNext()){
            student = it.next();
            System.out.println(student);
        }
    }
}
