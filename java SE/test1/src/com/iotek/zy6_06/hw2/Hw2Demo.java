package com.iotek.zy6_06.hw2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
1）Person类自身具备比较能力（实现Comparable<T>接口），
    比较的规则是“姓名字典顺序”（请用英文名）。
2）然后通过匿名内部类指定一种比较器（Comparator<T>），
    比较规则是“分数降序”。
3）写一个测试类，创建ArrayList<Person>集合，并添加5个Person对象。
    先用Collections工具类直接对该集合排序，输出排序结果①，并打印分割线。
4）然后用Collections工具类结合匿名内部类对该集合排序，输出排序结果②。
*/
public class Hw2Demo {
    public static void main(String[] args) {
        List<Person> pList = new ArrayList<>();
        pList.add(new Person(1,"Alice",95));
        pList.add(new Person(2,"Bob",96));
        pList.add(new Person(3,"Candy",97));
        pList.add(new Person(4,"David",98));
        pList.add(new Person(5,"Edward",99));
        // List中的元素自身实现了Comparable接口
        Collections.sort(pList);
        pList.forEach(p->System.out.println(p));
        System.out.println("------------------------");
        // 使用Comparator指定比较规则
        Collections.sort(pList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getScore() == p2.getScore() ? p1.getName().compareTo(p2.getName()) : p2.getScore() - p1.getScore();
            }
        });
        for (Person p : pList) {
            System.out.println(p);
        }
    }
}
