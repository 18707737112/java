package com.iotek.只能运行5次的Java程序;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
读取文件character.txt文件中所有的字符，
例如“asdascveasrgdfsdf”，获取该字符串中每一个字母出现的次数。
要求：按照字母表的顺序进行打印，打印结果是：a(2)b(1)...
*/
public class Hw2 {
    public static void main(String[] args) {
        fread("F:/java/a.txt");
    }
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
            char[] c = value.toCharArray();
            TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>(Collections.reverseOrder());

            for (int i = 0; i < c.length; i++) {
                char charSrc = c[i];
                if (tm.containsKey(charSrc)) {
                    int count = tm.get(charSrc);
                    tm.put(charSrc, count + 1);
                } else {
                    tm.put(charSrc, 1);
                }
            }
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
