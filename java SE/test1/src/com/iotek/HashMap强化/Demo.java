package com.iotek.HashMap强化;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        // 注意，此处是以Student为键（不推荐，作为键的数据最好是不可更改的，比如Integer，String）
        Map<Student,String> stuMap = new HashMap<>();
        Student stu1 = new Student("Alice",18,99);
        Student stu2 = new Student("Bob",18,99);
        Student stu3 = new Student("Candy",18,99);
        Student stu4 = new Student("David",18,99);
        stuMap.put(new Student("Alice",18,99),"爱丽丝1");
        stuMap.put(new Student("Alice",18,99),"爱丽丝2");
        stuMap.put(new Student("Alice",18,99),"爱丽丝3");
        stuMap.put(new Student("Alice",18,99),"爱丽丝4");
//        stuMap.put(stu2,"鲍勃");
//        stuMap.put(stu3,"凯迪");
//        stuMap.put(stu4,"大卫");

        System.out.println(stuMap);
    }
}
