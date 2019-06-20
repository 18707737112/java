package com.iotek.zy6_06.hw3;

import java.util.*;
import java.util.function.Consumer;

/*
请根据题目描述完成代码
1）创建Student类，包含String类型的name，int类型的age，double类型的score，并重写getter、setter等方法。
2）创建5个Student对象。已知一个Integer类型的学号对应唯一的一个Student对象。
3）将5个Student对象保存到HashMap容器中。
4）请对该集合中的元素按照分数降序排序（提示：可以转存其他容器）
5）将排序后的结果输出，格式：4-lanying-18-90.0
*/
public class Hw3Demo {
    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1,new Student("Alice",18,95));
        studentMap.put(2,new Student("Bob",18,96));
        studentMap.put(3,new Student("Candy",18,97));
        studentMap.put(4,new Student("David",18,98));
        studentMap.put(5,new Student("Edward",18,99));

        List<KV> list = new ArrayList<>();  //自定义list键值对
        Set<Map.Entry<Integer,Student>> entrySet = studentMap.entrySet();
        Iterator<Map.Entry<Integer,Student>> it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Student> e = it.next();
            list.add(new KV(e.getKey(),e.getValue()));
        }

        Collections.sort(list);
        list.forEach(s-> System.out.println(s));
    }
}
