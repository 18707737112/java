package com.iotek.zy6_12;

import java.io.*;
import java.util.*;

/*
读取文件character.txt文件中所有的字符，
例如“asdascveasrgdfsdf”，获取该字符串中每一个字母出现的次数。
要求：按照字母表的顺序进行打印，打印结果是：a(2)b(1)...
*/
public class Hw2 {
    public static void main(String[] args) {
        fread("F:/java/a.txt");
    }
    // 读取文件：
    public static void fread(String fileurl) {
        File file = new File(fileurl);
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader(file));
            String tem = null;
            String value = "";
            while ((tem = bfr.readLine()) != null) {
                value = value + tem;
            }
            System.out.println(value);
            // 将读取的字符串转换成字符数组：
            char[] c = value.toCharArray();
            // 定义一个map来存储结果：
            // HashMap<Character,Integer> tm = new
            // HashMap<Character,Integer>(Collections.reverseOrder());
            TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>(Collections.reverseOrder());// TreeMap可排序（传入一个反转比较器）

            for (int i = 0; i < c.length; i++) {
                char charSrc = c[i];
                if (tm.containsKey(charSrc)) { // 判断该键的值是否存在
                    int count = tm.get(charSrc);
                    tm.put(charSrc, count + 1);
                } else {
                    tm.put(charSrc, 1);
                }
            }

            // 取出Map中的键和值
            Iterator<Map.Entry<Character, Integer>> titer = tm.entrySet().iterator();
            while (titer.hasNext()) {
                Map.Entry<Character, Integer> map = titer.next();
                char key = map.getKey();
                int valu = map.getValue();
                System.out.println(key + "出现过" + valu + "次!");
            }

        } catch (Exception e) {
            System.err.println("文件读取错误");
        } finally {
            try {
                if (bfr != null) {
                    bfr.close();
                }
            } catch (Exception e2) {
                System.err.println("文件关闭错误");
            }
        }

    }
}
