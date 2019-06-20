package com.iotek.zy6_04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*定义一个List对象，如下
   List <String>list = new ArrayList<String>();
1) 在list中添加元素，nihao,wohao,dajiahao,nihao
2) 在list的第二个位置添加元素，tahao
) 用Iterator迭代器遍历打印list中元素*/
public class Hw1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("nihao");
        list.add("wohao");
        list.add("dajiahao");
        list.add("nihao");
        System.out.println("插入前增强for循环遍历：");
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("-------------------------");
        list.add(1,"tahao");
        System.out.println("插入后Iterator迭代器遍历：");
        Iterator<String> iterator = list.iterator();
        String s = null;
        while (iterator.hasNext()){
            s = iterator.next();
            System.out.print(s+" ");
        }

    }
}
