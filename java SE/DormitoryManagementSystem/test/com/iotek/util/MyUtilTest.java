package com.iotek.util;

import org.junit.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

//有效范围：获取键盘输入的指定范围的整数【min,max】
public class MyUtilTest {
    private MyUtil myUtil = new MyUtil();

    @Test
    public void setMyUtil(){
        myUtil.inputNum(0,1);
    }

    @Test
    public void set(){
        System.out.println("$~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~$");
        System.out.println("$------------------------------------$");
        System.out.println("$  ****** 欢迎使用宿舍管理系统 ******  $");
        System.out.println("$  ********  👨(●ˇ∀ˇ●)‍👩   ********  $");
        System.out.println("$------------------------------------$");
        System.out.println("$~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~$");
        System.out.println("                                    ");
        System.out.println(".........................🔒后台管理➡Ⅳ");
        System.out.println();
        System.out.println(" 👉 【1】登录 【2】 注册 【0】退出  💻 ‍");
        System.out.println();
        System.out.println(".........................👀忘记密码➡Ⅲ");
    }
}
