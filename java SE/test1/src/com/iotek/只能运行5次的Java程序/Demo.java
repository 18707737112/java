package com.iotek.只能运行5次的Java程序;

import java.io.*;

/**
 * 运行5次
 * 思路：
 * 1.首次运行时，写入文件1，表示打开次数
 * 2.之后运行时，先读数据，判断是否超出试用次数。抛异常or加1写入
 */
public class Demo {
    public static void main(String[] args) {
        // 给自己的软件整合一个试用机制
        int times = MyUtil.test(5);

        System.out.println("本次是第"+times+"次运行");
    }

}
