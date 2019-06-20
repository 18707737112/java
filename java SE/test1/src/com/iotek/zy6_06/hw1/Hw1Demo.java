package com.iotek.zy6_06.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 List对象中存放多个Person对象(此对象包含，名字，年龄、id)。
 按Person的年龄从小到大排序，
 假设年龄相等的话再按名字的大小来排序。
 求出年龄最大的那个学生信息。
 【Comparable和Comparator两种方式】
 */
public class Hw1Demo {
    public static void main(String[] args) {
        List<Person> pList = new ArrayList<>();
        pList.add(new Person(1,"Alice",18));
        pList.add(new Person(2,"Bob",28));
        pList.add(new Person(3,"Candy",18));
        // List中的元素自身实现了Comparable接口
        Collections.sort(pList);
        pList.forEach(p->System.out.println(p));
        System.out.println("------------------------");
        // 使用Comparator指定比较规则
        Collections.sort(pList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() == p2.getAge() ? p1.getName().compareTo(p2.getName()) : p1.getAge() - p2.getAge();
            }
        });
        for (Person p : pList) {
            System.out.println(p);
        }
        System.out.println("---年龄最大的学生信息---");
        System.out.println(pList.get(pList.size()-1));
    }
}
