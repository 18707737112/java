package com.iotek.view;

import com.iotek.biz.AdministratorBiz;
import com.iotek.biz.StudentBiz;
import com.iotek.biz.impl.AdministratorBizImpl;
import com.iotek.biz.impl.StudentBizImpl;
import com.iotek.entity.Administrator;
import com.iotek.entity.Student;
import com.iotek.entity.StudentCard;
import com.iotek.util.MyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//菜单视图
public class MenuView {
    private static Scanner input = new Scanner(System.in);
    private static AdministratorBiz administratorBiz = new AdministratorBizImpl();
    private static StudentBiz studentBiz = new StudentBizImpl();

    // 主页
    public static void homeView(){
        do {
            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("****** 欢迎使用宿舍管理系统 ******");
            System.out.println("----------------------------------");
            System.out.println();
            System.out.println("------------------后台管理入口（3）");
            System.out.println();
            System.out.println("【1】登录 【2】 注册 【0】退出");


            System.out.println("请选择编号：");
            // 根据用户输入的不同数字，跳转到不同界面
            int choice = MyUtil.inputNum(0, 3); // [0,2]
            switch (choice) {
                case 1:
                    StudentCard s = studentLoginView();
                    if (s == null) {
                        System.out.println();
                        return;
                    } else {
                        studentView(s);  // 登录成功：跳转到个人主页
                    }
                    break;
                case 2:
                    // 跳转到注册界面
                    boolean isOK = registerView();
                    System.out.println("注册" + (isOK ? "成功" : "失败"));
                    break;
                case 3:
                    Administrator adm = admLoginView();
                    if (adm == null) {
                        System.out.println();
                        System.out.println("---------------------");
                        System.out.println("   无法进入后台管理！ ");
                        System.out.println("---------------------");
                        return;
                    } else {
                        administratorView(adm);  // 登录成功：跳转到个人主页
                    }
                    break;
                case 0:
                    return ;
            }
        }while(true);
    }


    // 注册界面(只有用户，管理员只能登录，不能注册)
    public static boolean registerView(){
        System.out.println();
        System.out.println("***** 注册界面 *****");
        System.out.println("请输入学号");
        int id = MyUtil.inputNum(0,Integer.MAX_VALUE);
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

        return studentBiz.register(new StudentCard(id,password));
    }


    // 用户登录界面
    public static StudentCard studentLoginView(){
        System.out.println();
        System.out.println("***** 登录界面 *****");
        System.out.println("请输入学号");
        int id = MyUtil.inputNum(0,Integer.MAX_VALUE);
        System.out.println("请输入密码");
        String password = input.next();
        return studentBiz.login(new StudentCard(id,password));
    }

    //管理员登陆界面
    public static Administrator admLoginView(){
        System.out.println();
        System.out.println("***** 用户登录界面 *****");
        System.out.println("请输入用户名");
        String name = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        return administratorBiz.login(new Administrator(name,password));
    }

    // 管理员主页
    public static void administratorView(Administrator administrator){
        do {
            System.out.println();
            System.out.println("***** 管理员主页 *****");
            System.out.println("1 . 查看个人信息");
            System.out.println("2 . 查看所有学生信息");

            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 8);
            switch (choice) {
                case 1:
                    System.out.println(administrator);
                    break;
                case 2:
                    administratorBiz.lookAllStudents();
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:

                case 5:


                case 6:

                case 7:

                case 8:

                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }


    // 用户个人主页
    public static void studentView(StudentCard studentCard){
        do {
            System.out.println();
            System.out.println("***** 个人主页 *****");
            System.out.println("1 . 查看个人信息");
            System.out.println("2 . 修改密码");
            System.out.println("3 . 充值");
            System.out.println("4 . 模拟消费");

            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 8);
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("请输入金额(一次最多充值10000)");
                    int money = MyUtil.inputNum(0,10000);
                    studentBiz.topIn(studentCard,money);
                    break;
                case 4:
                    shop(studentCard);
                    break;
                case 5:

                case 6:

                case 7:

                case 8:

                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }

    public static void shop(StudentCard studentCard){
        do {
            System.out.println();
            System.out.println("***** 模拟消费 *****");
            System.out.println("1 . 纯净水（5元/升）");
            System.out.println("2 . 电费（200元/月）");
            System.out.println("3 . 碳酸饮料（3元/瓶）");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 3);
            switch (choice) {
                case 1:
                    studentBiz.topOut(studentCard,5);
                    break;
                case 2:
                    studentBiz.topOut(studentCard,200);
                    break;
                case 3:
                    studentBiz.topOut(studentCard,3);
                    break;
                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }
}
