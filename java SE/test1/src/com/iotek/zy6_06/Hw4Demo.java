package com.iotek.zy6_06;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

/*
 用TreeSet存储以下数据：
 “xiaoqiang”、 “zhangsan”、“lisi”、“xiaohua”、 “ruhua”、 “wangcai”
 要求按照字符串的长度进行排序后再存储（如果长度相同，则按字符串的自然顺序排序）
 */
public class Hw4Demo {
    public static void main(String[] args) {
        // 1.创建TreeSet对象，并指定排序规则
        Set<String> set = new TreeSet<String>(new Comparator<String>(){

            @Override
            public int compare(String s1, String s2) {
                if(s1.length() > s2.length()){
                    return 1;
                }else if(s1.length() < s2.length()){
                    return -1;
                }else{
                    return s1.compareTo(s2); // 字符串字典顺序升序排序
                }
            }
        });

        // 2.向TreeSet集合添加元素
        set.add("xiaoqiang");
        set.add("zhangsan");
        set.add("lisi");
        set.add("xiaohua");
        set.add("ruhua");
        set.add("wangcai");

        // 3.遍历TreeSet集合
        set.forEach(s -> System.out.println(s)); // 因为参数列表和方法体都只有一句话，所以可以省略括号
    }
}
