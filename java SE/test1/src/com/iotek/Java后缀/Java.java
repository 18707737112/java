package com.iotek.Java后缀;

import java.io.*;
import java.util.*;

public class Java {
    public static void main(String[] args){
        demo(new File("F:/a.txt"));
    }
    public static void demo(File file){
        BufferedReader bfr = null;   //定义字符读取(缓冲)流
        try{
            bfr = new BufferedReader(new FileReader(file));//给该流赋值
            String value = null; //定义一个临时接收文件中的字符串变量
            String newValue = "";    //接收文件中所有字符串的变量
            while((value = bfr.readLine())!=null){    //开始读取文件中的字符
                newValue = newValue+value;    //存入newValue变量中
            }
            char[] ch = newValue.toCharArray();//把newValue变成字符数组
            TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>(Collections.reverseOrder());/*定义一个TreeMap(因为TreeMap是有序的，存入的键值都有自然比较顺序功能,默认的是从小到大顺序，所有这里传了一个反转的比较器)，键对应字符，值对应字符出现的次数**/
            for(int x = 0;x<ch.length;x++){   //遍历ch  将ch中所有的字符存入一个Map集合中(TreeSet)，键对应字符，值对应字符出现的次数
                char c = ch[x];
                if(tm.containsKey(c)){  //如果TreeMap(tm)中有该键，则取出该键中的值，也就是出现的次数
                    int conut = tm.get(c);
                    tm.put(c,conut+1);  //存入把新值存入tm集合中，如果键相同的话， 新键会替换老键，值也随着变化了
                }
                else{
                    tm.put(c, 1);  //如果没有出现该键就说明是第一次出现，然后就存入1次
                }
            }
            //下面的是取出TreeMap(tm)中的键和值
            Set<Map.Entry<Character, Integer>> set = tm.entrySet();
            Iterator<Map.Entry<Character, Integer>> iter = set.iterator();
            while(iter.hasNext()){
                Map.Entry<Character, Integer> map = iter.next();
                char k = map.getKey();
                int v = map.getValue();
                System.out.print(k+"("+v+")  ");
            }
        }
        catch(IOException e){
            System.out.println("文件读取错误");
        }
        finally{
            try{
                if(bfr!=null)
                    bfr.close();
            }
            catch(IOException e){
                System.out.println("文件关闭错误");
            }
        }
    }
}
