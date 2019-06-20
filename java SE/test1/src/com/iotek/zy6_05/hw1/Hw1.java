package com.iotek.zy6_05.hw1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
要求如下：
1）创建Student类，包含String类型的name，int类型的age，double类型的score，
    并重写getter、setter等方法。
2）创建5个Student对象。键是Integer类型的学号，值是Student对象。
3）将5个Student对象保存到HashMap容器中。
4）遍历该容器，打印到控制台上。（直接println不得分）
*/
public class Hw1 {
    public static void main(String[] args) {
        Map<Integer,Student> studentMap = new HashMap<>();
        studentMap.put(1,new Student("Alice",18,99));
        studentMap.put(2,new Student("Bob",18,99));
        studentMap.put(3,new Student("Candy",18,99));
        studentMap.put(4,new Student("David",18,99));
        studentMap.put(5,new Student("Edward",18,99));

        Set<Map.Entry<Integer, Student>> set = studentMap.entrySet();
        Iterator<Map.Entry<Integer, Student>> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
