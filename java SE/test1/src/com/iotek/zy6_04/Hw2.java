package com.iotek.zy6_04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
在Arraylist中存放以下数据：
“张三”、“李四”、“王五”、“张三”、“aaa”、“aaa”、“aaa”、“bbb”
要求：去除ArrayList中的重复元素，然后通过迭代器遍历。
*/
public class Hw2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        String[] strings = {"张三","李四","王五","张三","aaa","aaa","aaa","bbb"};
        for (String s : strings) {
            list.add(s);
        }
        System.out.println("去重前增强for循环遍历：");
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();
        List<String> newList = new ArrayList<String>();
        newList = list;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (newList.get(i).equals(newList.get(j))){
                    newList.remove(j);
                    j--;
                }
            }
        }
        System.out.println("----------------------------");
        System.out.println("去重后Iterator迭代器遍历:");
        Iterator<String> iterator = newList.iterator();
        String s = null;
        while (iterator.hasNext()){
            s = iterator.next();
            System.out.print(s+" ");
        }
    }
}
