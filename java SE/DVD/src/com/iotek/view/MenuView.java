package com.iotek.view;

import com.iotek.biz.UserBiz;
import com.iotek.biz.impl.UserBizImpl;
import com.iotek.entity.User;
import com.iotek.util.MyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private static Scanner input = new Scanner(System.in);
    private static UserBiz userBiz = new UserBizImpl();

    public static void homeView(){
        do {
            System.out.println();
            System.out.println("****** 欢迎使用XX微型系统 ******");
            System.out.println("1 . 登录");
            System.out.println("2 . 注册");
            System.out.println("0 . 退出");
            System.out.println("请选择编号：");
            // 根据用户输入的不同数字，跳转到不同界面
            int choice = MyUtil.inputNum(0, 2); // [0,2]
            switch (choice) {
                case 1:
                    typeView();  //登陆选项：管理员or普通用户
                case 2:
                    // 跳转到注册界面
                    boolean isOK = registerView();
                    System.out.println("注册" + (isOK ? "成功" : "失败"));
                    break;
                case 0:
                    return ;
            }
        }while(true);
    }

    //登陆选项
    public static void typeView(){
        do {
            System.out.println();
            System.out.println("****** 欢迎登陆XX电影院网络平台 ******");
            System.out.println("1 . 管理员登录");
            System.out.println("2 . 普通用户登录");
            System.out.println("0 . 返回主页面");
            System.out.println("请选择编号：");
            int typeChoice = MyUtil.inputNum(0, 2);
            switch (typeChoice) {
                case 1:
                    User adm = admLoginView();
                    if (adm == null) {
                        System.out.println("---------------------");
                        System.out.println("      登录失败         ");
                        System.out.println("请重新登陆或者联系经理！");
                        System.out.println("---------------------");
                    } else {
                        administratorView(adm);  // 登录成功：跳转到个人主页
                    }
                    break;
                case 2:
                    User u = userLoginView();
                    if (u == null) {
                        System.out.println();
                        System.out.println("---------------------");
                        System.out.println("    该用户不存在    ");
                        System.out.println("请到注册界面进行注册!");
                        System.out.println("---------------------");
                        return;
                    } else {
                        userView(u);  // 登录成功：跳转到个人主页
                    }
                    break;
                case 0:
                    homeView();
            }
        }while(true);
    }

    // 注册界面(只有用户，管理员只能登录，不能注册)
    public static boolean registerView(){
        System.out.println();
        System.out.println("***** 注册界面 *****");
        System.out.println("请输入姓名");
        String name = input.next();
        String password = null;
        do {
            System.out.println("请输入密码");
            password = input.next();
            System.out.println("请再次输入密码");
            String password2 = input.next();
            if (!password.equals(password2)) {
                System.err.println("两次密码不一致，请重新输入");
                continue;
            }
            break; // 如果两次密码一致，则结束while循环
        }while(true);

        return userBiz.register(new User(name,password,2));
    }


    // 用户登录界面
    public static User userLoginView(){
        System.out.println();
        System.out.println("***** 登录界面 *****");
        System.out.println("请输入用户名");
        String name = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        return userBiz.login(new User(name,password,2));
    }

    //管理员登陆界面
    public static User admLoginView(){
        System.out.println();
        System.out.println("***** 用户登录界面 *****");
        System.out.println("请输入用户名");
        String name = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        return userBiz.login(new User(name,password,1));
    }
    // 管理员主页
    public static void administratorView(User user){
        do {
            System.out.println();
            System.out.println("***** 管理员主页 *****");
            System.out.println("1 . 查看个人信息");
            System.out.println("2 . 查看所有用户信息");

            
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 8);
            switch (choice) {
                case 1:
                    System.out.println(user);
                    break;
                case 2:

                    break;
                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }

    private static void management(User user) {
    }

    // 用户个人主页
    public static void userView(User user){
        do {
            System.out.println();
            System.out.println("***** 个人主页 *****");
            System.out.println("1 . 查看个人信息");
            System.out.println("2 . 修改密码");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 8);
            switch (choice) {
                case 1:
                    System.out.println(user);
                    break;
                case 2:
                    break;
                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }
}

