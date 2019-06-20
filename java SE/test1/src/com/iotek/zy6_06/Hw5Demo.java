package com.iotek.zy6_06;

import java.util.*;

/**
 随机产生50个30到35的整数，统计每个数字出现的次数（TreeMap实现），
 输出时按照数字的降序排列，并且统计出现次数最多的数字和它的次数。
 PS：如果有两个数字出现的次数一样，则只需输出其中一个。
 */
public class Hw5Demo {
    public static void main(String[] args) {
        Map<Integer/*数字*/,Integer/*次数*/> treeMap = new TreeMap<>((i1,i2)->{return i2-i1;});
        Random random = new Random();
        for(int i = 0; i < 50; i ++){
            int num = random.nextInt(6)+30;
            if(!treeMap.containsKey(num)){
                treeMap.put(num,1); // 初次相遇是第一次相遇，所以次数是1
            }else{
                treeMap.put(num,treeMap.get(num)+1); // 次数加1
            }
        }

        // 遍历TreeMap
        treeMap.forEach((k,v)->{
            System.out.println(k+" -- " + v);
        });

        /*System.out.println("------------");
        //加强版
        int max = Collections.max(treeMap.values()); // 求出次数的最大值

        Set<Map.Entry<Integer, Integer>> entrySet = treeMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if(entry.getValue() == max){
                System.out.println(entry.getKey() + " == " +entry.getValue());
            }
        }

        // Lambda表达式：遍历+筛选
        treeMap.forEach((k,v)->{System.out.print(v==max? k+" - "+v +"\n":"");});*/
    }
}
