package com.iotek.只能运行5次的Java程序;

import java.io.*;

public class MyUtil {
    // limit表示试用总次数，返回当前是第几次运行程序
    public static int test(int limit){
        int times = read();

        // times表示已经运行的次数
        if(times>=limit){
            // 抛异常
            throw new RuntimeException("试用次数已用尽，请购买注册码！");
        }

        write(times+1); // 次数+1

        return times+1;
    }

    private static void write(int times) {
        File file = new File("file/times.txt");
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
        File file = new File("file/times.txt");
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
