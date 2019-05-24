package com.iotek.zy5_23;

import java.util.Scanner;

/*
输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数
（提示：String到字符数组的转换通过方法toCharArray()完成）
         msy-haitong dahai java:ee PD1902
*/
public class C {
    public static void main(String[] args) {

        count(string());

    }
    private static String string(){
        System.out.println("请输入您需要统计的字符串：");
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n"); //检测控制台中的空格
        String s = input.next();
        System.out.println();
        return s;
    }
    private static void count(String s){
        int letter = 0;
        int blak = 0;
        int number = 0;
        int other = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' '){
                blak++;
            }else if(arr[i]>='0' && arr[i]<='9'){
                number++;
            }else if(arr[i]>='a' && arr[i]<='z' || arr[i]>='A' && arr[i]<='Z'){
                letter++;
            }else {
                other++;
            }
        }
        System.out.println("--------统计结果--------");
        System.out.println("英文字母的个数:"+letter);
        System.out.println("空格的个数:"+blak);
        System.out.println("数字的个数:"+number);
        System.out.println("其它字符的个数:"+other);
    }
}
