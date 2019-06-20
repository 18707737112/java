package com.iotek.登录注册.com.lanying.view;


import com.iotek.登录注册.com.lanying.biz.UserBiz;
import com.iotek.登录注册.com.lanying.biz.impl.UserBizImpl;
import com.iotek.登录注册.com.lanying.entity.User;
import com.iotek.登录注册.com.lanying.util.MyUtil;

import java.util.Scanner;

public class MenuView {
    private static Scanner input = new Scanner(System.in);
    private static UserBiz userBiz = new UserBizImpl();

    // 主页
    public static void homeView(){
        do {
            System.out.println("****** 欢迎使用XX微型系统 ******");
            System.out.println("1 ==> 注册");
            System.out.println("2 ==> 登录");
            System.out.println("0 ==> 退出");
            System.out.println("请选择：");
            // 根据用户输入的不同数字，跳转到不同界面
            int choice = MyUtil.inputNum(0, 2); // [0,2]
            switch (choice) {
                case 1:
                    // 跳转到注册界面
                    boolean isOK = registerView();
                    System.out.println("注册" + (isOK ? "成功" : "失败"));
                    break;
                case 2:
                    // 跳转到登录界面
                    User u = loginView();
                    if (u == null) {
                        System.out.println("登录失败");
                    } else {
                        // 登录成功
                        // 跳转到个人主页
                        userView(u);
                    }
                    break;
                case 0:
                    return ;
            }
        }while(true);
    }


    // 注册界面
    public static boolean registerView(){
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

        return userBiz.register(new User(name,password,1));
    }


    // 登录界面
    public static User loginView(){
        System.out.println("***** 登录界面 *****");
        System.out.println("请输入用户名");
        String name = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        return userBiz.login(new User(name,password,1));
    }


    // 用户个人主页
    public static void userView(User user){
        do {
            System.out.println("***** 个人主页 *****");
            System.out.println("1 ==> 查看个人信息");
            System.out.println("2 ==> 充值");
            System.out.println("3 ==> 修改密码");
            System.out.println("4 ==> 租赁DVD");
            System.out.println("0 ==> 返回上一层");
            int choice = MyUtil.inputNum(0, 4);
            switch (choice) {
                case 1:
                    System.out.println(user);
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("敬请期待！");
                    break;
                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }
}
