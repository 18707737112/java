package com.iotek.zy5_25.cc;

import java.util.Scanner;

public class Person {
    String name = "匿名"; //名字
    int score = 0;      //积分

    public int showFist(){
        //接收用户的选择
        Scanner input = new Scanner(System.in);
        System.out.println("\n请出拳:1.剪刀  2.石头    3.布");
        int show = input.nextInt();
        //输出出拳结果，并且返回
        switch (show) {
            case 1:
                System.out.println(name+"你出拳：剪刀");
                break;
            case 2:
                System.out.println(name+"你出拳：石头");
                break;
            case 3:
                System.out.println(name+"你出拳：布");
                break;
        }
        return show;
    }
}
