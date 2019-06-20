package com.iotek.试用30天的Java程序;

import java.io.*;
import java.util.Date;

/**
 * 思路：
 * 1.首次运行程序时，写入当前系统时间
 * 2.后续运行程序时，读取文件，比较时间
 */
public class Demo {
    public static void main(String[] args) {
        long first = read(); // 返回首次运行程序时的时间
        System.out.println(new Date().getTime()-first);
        if((new Date().getTime()-first) > 30L*24*60*60*1000){ // 注意此处越界！需要用long型
            throw new IllegalArgumentException("试用期已超出，请购买注册码！");
        }

        System.out.println("Hello World!");
    }

    private static long read() {
        File file = new File("firstTime.txt");
        if(!file.exists()){ // 首次运行
            long now = new Date().getTime();
            // 写入当前系统时间
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(file);
                pw.println(now+"");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if(pw != null){
                    pw.close();
                }
            }
            return now;
        }
        // 读取数据
        FileReader fr = null;
        BufferedReader br = null;
        String line = "0";
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Long.parseLong(line);
    }
}
