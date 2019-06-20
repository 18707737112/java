package com.iotek.zy6_03;

import java.util.Scanner;

/*
在一个类中编写一个方法，这个方法搜索一个字符数组中是否存在某个字符，
如果存在，则返回这个字符在字符数组中第一次出现的位置（下标），
否则，返回-1。
要搜索的字符数组和字符都以参数形式传递给该方法，如果传入的数组为null，
就抛出IllegalArgumentException异常。
在类的main方法中以各种可能出现的情况测试验证该方法编写的是否正确，
例如：
字符不存在，字符存在，传入的数组为null等,但是无论如何要打印出再见2个字。
*/
public class Hw2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.nextLine();
        char ch = 'e';
        char[] chs = str.toCharArray();
        int num = check(chs, ch);
        System.out.println("比较的字符是:"+"e"+"\n索引号是："+num);
    }

    private static int check(char[] chs, char ch) {
        if(chs==null){
            throw new IllegalArgumentException("数组不能为空！");
        }
        for (int x = 0; x < chs.length; x++) {
            if (chs[x] == ch) {
                return x+1;
            }
        }
        return -1;
    }
}
