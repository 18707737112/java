package com.iotek.zy5_30.hw3;

import java.util.Scanner;

/*
编程实现:
找出两个字符串中最大公共子字符串。
如:
"abccade","dgcadde"的最大子串为"cad"
*/
public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();
        //找出两个字符串中谁的长度长
        String min=(s1.length()<=s2.length())?s1:s2;
        String max=(min.equals(s1))?s2:s1;
        //如果长的字符串包含短的字符串，直接返回
        if(max.contains(min)){
            System.out.println(min);
            return;
        }
        //字符串从末尾开始慢慢缩减长度，如果包含就直接输出并返回即可
        //外层循环控制start的起始位置
        for(int i=0;i<min.length();i++){
            //每次都是从末端缩减长度，这样的话，如果包含就可以直接输出，即为包含的最长的字符串
            for(int start=i,end=min.length();end>start+1;end--){
                String temp=min.substring(start,end);
                if(max.contains(temp)){
                    System.out.println(temp);
                    return;
                }
            }
        }

    }

}
