package com.iotek.zy6_12;

import java.io.*;
/*
写一个程序，要求用户只能打开5次，在第6次打开的时候就抛出异常提示“打开失败”。
*/
public class Hw1 {
    public static void main(String[] args) {
        int times = test(5);
        System.out.println("本次是第"+times+"次运行");
    }

    public static int test(int limit){
        int times = read();
        if(times>=limit){
            throw new RuntimeException("试用次数已用尽，请购买注册码！");
        }
        write(times+1);
        return times+1;
    }
    private static void write(int times) {
        File file = new File("F:/times.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            pw.println(times);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(pw != null){
                pw.close();
            }
        }
    }
    private static int read() {
        File file = new File("F:/times.txt");
        if(!file.exists()){ // 文件不存在，说明是首次运行，说明已经运行过0次
            return 0;
        }
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = br.readLine();
            return Integer.parseInt(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        return -1;
    }
}
