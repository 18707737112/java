package com.iotek.zy6_05.hw2;

import java.util.HashMap;
import java.util.Map;

/*
给定一系列字符串：
"chenhao"
"zhangsan"
"zhangsan"
"chenhao"
"lisi"
"wangwu"
"zhaoliu"
"xiaoqiang"
"haha"
打印输出各个字符串出现的次数
（使用HashMap实现，键保存字符串，值保存保存出现的次数）
*/
public class Hw2 {
    public static void main(String[] args) {
        String[] strings = {
                "chenhao","zhangsan","zhangsan",
                "chenhao", "lisi", "wangwu",
                "zhaoliu", "xiaoqiang", "haha"
        };
        Map<String,Integer> map = new HashMap<>();
        String key;
        Integer value;
        for (int i = 0; i < strings.length; i++) {
            key = strings[i];
            value = map.get(key);
            if (value == null){
                map.put(key,1);
            }else {
                map.put(key,value+1);
            }
        }
        map.forEach((k,v)->{ System.out.println(k+"-->出现的次数："+v); });
    }
}
