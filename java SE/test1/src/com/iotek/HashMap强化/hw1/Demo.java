package com.iotek.HashMap强化.hw1;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * HashMap
 * 1）创建Student类，包含String类型的name，int类型的age，double类型的score，并重写getter、setter等方法。
 * 2）创建5个Student对象。已知一个Integer类型的学号对应唯一的一个Student对象 <K,V>
 * 3）将5个Student对象保存到HashMap容器中。 put
 * 4）遍历该容器，打印出来。 Map的遍历
 */
public class Demo {
    public static void main(String[] args) {
        // Hash结构存储元素时，计算的是Key的hashCode
        Map<Integer,Student> stuMap = new HashMap<>();
        stuMap.put(1,new Student("Alice",18,99));
        stuMap.put(2,new Student("Bob",18,99));
        stuMap.put(3,new Student("Candy",18,99));
        stuMap.put(4,new Student("David",18,99));
        stuMap.put(5,new Student("Edward",18,99));

        // 1.迭代器-Set
        Set<Integer> keySet = stuMap.keySet();
        Iterator<Integer> it1 = keySet.iterator();
        while(it1.hasNext()){
            int key = it1.next();
            System.out.println(key + " -- " +stuMap.get(key));
        }

        // 2.迭代器-Set
        Set<Map.Entry<Integer, Student>> entrySet = stuMap.entrySet();
        Iterator<Map.Entry<Integer, Student>> it2 = entrySet.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

        // 3.匿名内部类
        stuMap.forEach(new BiConsumer<Integer, Student>() {
            @Override // 对HashMap中的每一个键值对所做的操作
            public void accept(Integer id, Student stu) {
                System.out.println(id + " -- " + stu);
            }
        });

        // 4.Lambda表达式，是对匿名内部类的方式进行了代码简化
        stuMap.forEach((id,stu)->{System.out.println(id + " == " + stu);});
    }
}
