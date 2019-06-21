package com.iotek.view;

import com.iotek.biz.AdministratorBiz;
import com.iotek.biz.StudentBiz;
import com.iotek.biz.impl.AdministratorBizImpl;
import com.iotek.biz.impl.StudentBizImpl;
import com.iotek.dao.StudentCardDao;
import com.iotek.dao.impl.StudentCardDaoImpl;
import com.iotek.entity.*;
import com.iotek.util.MyUtil;
import com.iotek.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//菜单视图
public class MenuView {
    //private static int myMoney = 20;
    private static Scanner input = new Scanner(System.in);
    private static StudentCardDao studentCardDao = new StudentCardDaoImpl();
    private static AdministratorBiz administratorBiz = new AdministratorBizImpl();
    private static StudentBiz studentBiz = new StudentBizImpl();

    // 主页
    public static void homeView(){
        do {
            System.out.println("$~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~$");
            System.out.println("$------------------------------------$");
            System.out.println("$  ****** 欢迎使用宿舍管理系统 ******  $");
            System.out.println("$  ********  👨(●ˇ∀ˇ●)‍👩   ********  $");
            System.out.println("$------------------------------------$");
            System.out.println("$~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~$");
            System.out.println("                                    ");
            System.out.println(".........................🔒后台管理➡④");
            System.out.println();
            System.out.println(" 👉 【1】登录 【2】 注册 【0】退出  💻 ‍");
            System.out.println();
            System.out.println(".........................👀忘记密码➡③");
            System.out.println();

            System.out.println("👉请选择编号：");
            // 根据用户输入的不同数字，跳转到不同界面
            int choice = MyUtil.inputNum(0, 4); // [0,2]
            switch (choice) {
                case 1:
                    StudentCard s = studentLoginView();
                    if (s == null) {
                        System.out.println();
                        homeViewNew();
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
                    System.out.println("请输入你的学号：");
                    int id = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    forgotPass(id);
                    break;
                case 4:
                    Administrator adm = admLoginView();
                    if (adm == null) {
                        System.out.println();
                        System.out.println("---------------------");
                        System.out.println("$  无法进入后台管理！$");
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


    //新主页
    public static void homeViewNew(){
        do {
            System.out.println();
            System.out.println("$----------------主页----------------$");
            System.out.println("                                    ");
            System.out.println(".........................🔒后台管理➡④");
            System.out.println();
            System.out.println(" 👉 【1】登录 【2】 注册 【0】退出  💻 ‍");
            System.out.println();
            System.out.println(".........................👀忘记密码➡③");
            System.out.println();

            System.out.println("👉请选择编号：");
            int choice = MyUtil.inputNum(0, 4);
            switch (choice) {
                case 1:
                    StudentCard s = studentLoginView();
                    if (s == null) {
                        System.out.println();
                        //return;
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
                    System.out.println("请输入你的学号：");
                    int id = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    forgotPass(id);
                    break;
                case 4:
                    Administrator adm = admLoginView();
                    if (adm == null) {
                        System.out.println();
                        System.out.println("---------------------");
                        System.out.println("$  无法进入后台管理！$");
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


    //忘记密码
    private static void forgotPass(int studentId) {
        //System.out.println("还没完成！");
        //return;
        List<Encrypted> list = studentBiz.myAllEncrypted(studentId);
        StudentCard studentCard = studentCardDao.queryStudentCardById(studentId);
        int n = 0;
        do{
            if (n == 3){
                System.err.println("亲，对不起，您已经错误3次了,本次服务到次结束！");
                System.exit(0);
            }

            int getList = RandomUtil.number(list.size());
            Encrypted encrypted = list.get(getList);
            System.out.println("🔦密保问题：");
            System.out.println(encrypted.getProblem());
            System.out.println("🖊请在下面输入您的答案：");
            String s = input.next();

            if (s.equals(encrypted.getAnswer())){
                System.out.println("😊亲，请记得您的密码哟！");
                System.out.println("密码："+studentCard.getPassword());
                return;
            }

            n++;
            System.err.println("亲，输入错误！("+n+"次)");

        }while (true);

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
            System.out.println("1 . 个人信息");
            System.out.println("2 . 学生信息");

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
            System.out.println("1 . 个人信息🧒");
            System.out.println("2 . 修改密码🔒");
            System.out.println("3 . 充值💴");
            System.out.println("4 . 模拟消费💸");
            System.out.println("5 . 余额提醒设置🚨");
            System.out.println("6 . 报修单🛠");
            //System.out.println("7 . ");

            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 6);

            switch (choice) {
                case 1:
                    findMyAll(studentCard);
                    break;
                case 2:
                    myNewPass(studentCard);
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
                    System.out.println("请设置金额（0-100元）");
                    int myMoney = MyUtil.inputNum(0,100);
                    studentBiz.myRemind(studentCard,myMoney);
                    break;
                case 6:
                    studentRepair(studentCard);
                    break;
                case 7:
                    System.out.println("没有写");
                    break;
                case 8:
                    System.out.println("没有写");
                    break;
                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }

    private static void findMyAll(StudentCard studentCard) {
        //System.out.println("没有写");
        do{
            System.out.println();
            System.out.println("***** 个人信息 *****");
            System.out.println("1 . 全部信息");
            System.out.println("2 . 学生信息");
            System.out.println("3 . 学生卡信息");
            System.out.println("4 . 个人宿舍信息");
            System.out.println("5 . 个人密保信息");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 4);
            switch (choice) {
                case 1:
                    System.out.println("没有写");
                    break;
                case 2:
                    System.out.println("没有写");
                    break;
                case 3:
                    System.out.println("没有写");
                    break;
                case 4:
                    System.out.println("没有写");
                    break;
                case 5:
                    studentBiz.myAllEncrypted(studentCard.getStudentId());
                    break;
                case 0:
                    return; // 返回上一层
            }
        }while (true);
    }


    //修改密码
    private static void myNewPass(StudentCard studentCard) {
        System.out.println("🔒密码修改");
        System.out.println("原密码：");
        String pass = input.next();
        System.out.println("新密码：");
        String newPassword = input.next();
        System.out.println("重复密码：");
        String repeatPass = input.next();
        if (studentCard.getPassword().equals(newPassword)){
            if (newPassword.equals(repeatPass)){
                studentBiz.newPass(studentCard,newPassword);
            }else {
                System.out.println("两次密码不一致，设置失败！");
            }
        }else {
            System.out.println("密码错误，请重新确认您的登陆密码！");
        }

    }


    //填写报修单
    private static void studentRepair(StudentCard studentCard) {
        //System.out.println("请输入学号");
        int studentId = studentCard.getStudentId();
        System.out.println("请输入宿舍楼号");
        int buildId = MyUtil.inputNum(1,10);
        System.out.println("请输入宿舍号");
        int roomId = MyUtil.inputNum(1,10);
        System.out.println("请输入报修物品");
        String thing = input.next();
        Repair repair = new Repair(studentId,buildId,roomId,thing);
        boolean flag = studentBiz.theRepair(repair);
        if (flag){
            System.out.println("😊😊😊亲，报修成功！");
        }else {
            System.err.println("报修失败，请重新申请！");
        }
    }


    //模拟消费
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
