package com.iotek.view;

import com.iotek.biz.AdministratorBiz;
import com.iotek.biz.StudentBiz;
import com.iotek.biz.impl.AdministratorBizImpl;
import com.iotek.biz.impl.StudentBizImpl;
import com.iotek.dao.*;
import com.iotek.dao.impl.*;
import com.iotek.entity.*;
import com.iotek.util.CodeUtil;
import com.iotek.util.MyUtil;
import com.iotek.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//菜单视图
public class MenuView {
    //private static int myMoney = 20;
    private static Scanner input = new Scanner(System.in);
    private static StudentDao studentDao = new StudentDaoImpl();
    private static EncryptedDao encryptedDao = new EncryptedDaoImpl();
    private static CheckDao checkDao = new CheckDaoImpl();
    private static BedDao bedDao = new BedDaoImpl();
    private static RoomDao roomDao = new RoomDaoImpl();
    private static DormitoryDao dormitoryDao = new DormitoryDaoImpl();
    private static StudentCardDao studentCardDao = new StudentCardDaoImpl();
    private static AdministratorBiz administratorBiz = new AdministratorBizImpl();
    private static StudentBiz studentBiz = new StudentBizImpl();
    private static RepairDao repairDao = new RepairDaoImpl();
    //private static StudentDao studentDao = new StudentDaoImpl();

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
                    Student student = studentDao.queryStudentById(id);
                    if (student == null){
                        System.out.println("该学生不存在！");
                        break;
                    }
                    forgotPass(id);
                    break;
                case 4:
                    Administrator adm = admLoginView();
                    if (adm == null) {
                        System.out.println();
                        System.out.println("----------------------------------");
                        System.out.println("$     无法进入后台管理！          $");
                        System.out.println("$如果是设备问题请及时联系技术人员！$");
                        System.out.println("----------------------------------");
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
                        System.out.println("登录失败！");
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
        Student student = studentDao.queryStudentById(id);
        if (student == null){
            System.out.println("该学生不存在，只有在校生才能注册！");
            return false;
        }
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
        Student student = studentDao.queryStudentById(id);
        if (student == null){
            System.out.println("该学生不存在！");
            return null ;
        }
        System.out.println("请输入密码");
        String password = input.next();
        StudentCard s = studentBiz.login(new StudentCard(id,password));
        if (s == null){
            return null;
        }else {
            return s;
        }
    }


    //管理员登陆界面
    public static Administrator admLoginView(){
        System.out.println();
        System.out.println("***** 用户登录界面 *****");
        System.out.println("请输入用户名");
        String name = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        Administrator administrator =  administratorBiz.login(new Administrator(name,password));
        System.out.println("请输入密钥（每天主管发放）："+administrator.getAdministratorKey());
        String s = input.next();
        if (s.equals(administrator.getAdministratorKey())){
            return administrator;
        }
        return null;
    }


    // 管理员主页
    public static void administratorView(Administrator administrator){
        do {
            System.out.println();
            System.out.println("***** 管理员主页 *****");
            System.out.println("1 . 信息查询");
            System.out.println("2 . 信息录入");
            System.out.println("3 . 入住迁出");
            System.out.println("4 . 宿舍调换");
            System.out.println("5 . 修改信息");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 20);
            switch (choice) {
                case 1:
                    queryAllInformation(administrator);
                    break;

                case 2:
                    inputInformation();
                    break;

                case 3:
                    in_out();
                    break;

                case 4:
                    updateRoom();
                    break;
                case 5:
                    updateInformation();
                    break;

                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }


    //修改信息
    private static void updateInformation() {
        do {
            System.out.println();
            System.out.println("***** 修改信息 *****");
            System.out.println("1 . 修改学生信息");
            System.out.println("2 . 紧急修改学号");
            System.out.println("3 . 已修记录修改");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 3);
            switch (choice) {
                case 1:
                    System.out.println("请输入学号");
                    int id2 = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Student s = studentDao.queryStudentById(id2);
                    if (s == null){
                        System.out.println("没有该学生！");
                        break;
                    }
                    String name2 = s.getStudentName();
                    System.out.println("姓名:"+name2);
                    String sex2 = s.getSex();
                    System.out.println("性别:"+sex2);
                    System.out.println("是否修改（1.修改/2.放弃）");
                    int is = MyUtil.inputNum(1,2);
                    if (is == 2){
                        break;
                    }
                    System.out.println("请输入姓名");
                    String nameNew2 = input.next();
                    System.out.println("请输入性别[1.男/2.女]");
                    String sexNew2;
                    int newSex2 = MyUtil.inputNum(1,2);
                    if (newSex2 == 1){
                        sexNew2 = "男";
                    }else {
                        sexNew2 = "女";
                    }
                    Student student2 = new Student(id2,nameNew2,sexNew2);
                    administratorBiz.updateStudent(student2);
                    break;

                case 2:
                    System.out.println("请输入学号");
                    int id3 = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Student s1 = studentDao.queryStudentById(id3);
                    if (s1 == null){
                        System.out.println("没有该学生！");
                        break;
                    }
                    String name3 = s1.getStudentName();
                    System.out.println("姓名:"+name3);
                    String sex3 = s1.getSex();
                    System.out.println("性别:"+sex3);
                    //Student student3 = new Student(id3,name3,sex3);
                    System.out.println("修改学号");
                    int idNew3 = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    administratorBiz.updateStudentId(s1,idNew3);
                    break;

                case 3:
                    System.out.println("请输入报修单号");
                    int id33 = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Repair r = repairDao.queryRepairById(id33);
                    if (r == null){
                        System.out.println("没有该报修记录！");
                        break;
                    }
                    System.out.println(r);
                    System.out.println("是否修改【1.是/0.否】");
                    int num = MyUtil.inputNum(0,1);
                    if (num == 0){
                        break;
                    }
                    boolean f = administratorBiz.repair(id33,num);
                    if (f){
                        System.out.println("已修！");
                        break;
                    }
                    System.out.println("未修！");
                    break;

                /*case 4:

                    break;*/

                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }


    //宿舍调换
    private static void updateRoom() {
        do {
            System.out.println();
            System.out.println("***** 调换宿舍 *****");
            System.out.println("1 . 单人调换");
            System.out.println("2 . 双人互换");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 2);
            switch (choice) {
                case 1:
                    System.out.println("请输入学号");
                    int id1 = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Student s11 = studentDao.queryStudentById(id1);
                    if (s11 == null){
                        System.out.println("没有该学生！");
                        break;
                    }
                    String name11 = s11.getStudentName();
                    System.out.println("姓名:"+name11);
                    String sex11 = s11.getSex();
                    System.out.println("性别:"+sex11);
                    System.out.println("请输入宿舍楼号");
                    int ssl1 = MyUtil.inputNum(0,100);
                    System.out.println("请输入宿舍号");
                    int ss1 = MyUtil.inputNum(0,100);
                    System.out.println("请输入床位号");
                    int cw1 = MyUtil.inputNum(0,10);
                    Bed bed1 = new Bed(ssl1,ss1,cw1,id1);
                    boolean flag = administratorBiz.updateBed(bed1,sex11);
                    if (flag){
                        System.out.println("调换成功！");
                        break;
                    }
                    System.out.println("调换失败！");
                    break;

                case 2:
                    System.out.println("请输入学号");
                    int id21 = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Student s21 = studentDao.queryStudentById(id21);
                    if (s21 == null){
                        System.out.println("没有该学生！");
                        break;
                    }
                    System.out.println(s21);
                    System.out.println("请输入学号");
                    int id22 = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Student s22 = studentDao.queryStudentById(id22);
                    if (s22 == null){
                        System.out.println("没有该学生！");
                        break;
                    }
                    System.out.println(s22);
                    boolean flag21 = administratorBiz.updateTowBed(id21,id22);
                    if (flag21){
                        System.out.println("交换成功！");
                        break;
                    }
                    System.out.println("交换失败,注意学生性别！");
                    break;

                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }


    //信息录入
    private static void inputInformation() {
        do {
            System.out.println();
            System.out.println("***** 信息录入 *****");
            System.out.println("1 . 入学信息录入");
            System.out.println("2 . 宿舍楼信息录入");
            System.out.println("3 . 宿舍房间信息录入");
            //System.out.println("4 . 宿舍床位信息录入");
            //System.out.println("5 . ");
            //System.out.println("6 . ");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 3);
            switch (choice) {
                case 1:
                    System.out.println("请输入姓名");
                    String name = input.next();
                    System.out.println("请输入性别[1.男/2.女]");
                    String sex;
                    int intSex = MyUtil.inputNum(1,2);
                    if (intSex == 1){
                        sex = "男";
                    }else {
                        sex = "女";
                    }
                    Student student = new Student(name,sex);
                    boolean fiag = administratorBiz.addStudent(student);
                    if (fiag){
                        System.out.println("提交成功！");
                    }else {
                        System.out.println("提交失败！");
                    }
                    break;

                case 2:
                    //建楼，房间数量确定，不可更改
                    System.out.println("请输入宿舍楼号");
                    int ssl2 = MyUtil.inputNum(0,100);
                    System.out.println("请输入性别[1.男/2.女]");
                    String sex2;
                    int intSex2 = MyUtil.inputNum(1,2);
                    if (intSex2 == 1){
                        sex2 = "男";
                    }else {
                        sex2 = "女";
                    }
                    System.out.println("请输入宿舍数量");
                    int ssNum2 = MyUtil.inputNum(0,100);
                    Dormitory d2 = new Dormitory(ssl2,sex2,ssNum2);
                    boolean flag2 = administratorBiz.addDormitory(d2);
                    if (flag2){
                        System.out.println("创建成功！");
                    }else {
                        System.out.println("创建失败！！！！！！");
                    }
                    break;

                case 3:
                    //管理宿舍
                    System.out.println("请输入宿舍楼号");
                    int ssl3 = MyUtil.inputNum(0,100);
                    Dormitory dx3 = dormitoryDao.queryDormitoryById(ssl3);
                    if (dx3 == null){
                        System.out.println("`````````````````````````");
                        System.out.println("该宿舍楼不存在~~~");
                        System.out.println("`````````````````````````");
                        break;
                    }
                    System.out.println("-----------------------------------");
                    System.out.println("宿舍编号列表：");
                    int n = dx3.getRoomNum();
                    for (int i = 0; i < n; i++) {
                        int a = i+1;
                        System.out.print(a+"号宿舍"+" ");
                    }
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("请输入宿舍号");
                    int ss3 = MyUtil.inputNum(0,100);
                    System.out.println("请输入床位数量");
                    int cNum3 = MyUtil.inputNum(0,100);
                    Room r3 = new Room(ssl3,ss3,cNum3);
                    boolean flag3 = administratorBiz.addRoom(r3);
                    if (flag3){
                        System.out.println("创建成功！");
                    }else {
                        System.out.println("创建失败！！！！！！");
                    }
                    System.out.println("开始自动创建床位~~~~~~~~");
                    for (int i = 0; i < cNum3; i++) {
                        int cw = i+1;
                        Bed b = new Bed(ssl3,ss3,cw);
                        boolean flag33 = administratorBiz.addB(b);
                        if (flag33){
                            System.out.println(cw+"号床位创建成功！");
                        }else {
                            System.out.println("创建失败！！！！！！");
                        }
                    }
                    break;

                case 4:
                    //System.out.println("床位管理没有写");
                    System.out.println("请输入宿舍楼号");
                    int ssl4 = MyUtil.inputNum(0,100);
                    Dormitory dormitory = dormitoryDao.queryDormitoryById(ssl4);
                    if (dormitory == null){
                        System.out.println("`````````````````````````");
                        System.out.println("该宿舍楼不存在~~~");
                        System.out.println("`````````````````````````");
                        break;
                    }
                    administratorBiz.findNullBed(dormitory);

                    break;
                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }


    //信息查询
    private static void queryAllInformation(Administrator administrator) {
        do {
            System.out.println();
            System.out.println("***** 信息查询 *****");
            System.out.println("1 . 个人信息");
            System.out.println("2 . 全部学员信息");
            System.out.println("3 . 指定学员信息");
            System.out.println("4 . 宿舍楼入住率");
            System.out.println("5 . 宿舍入住情况");
            System.out.println("6 . 宿舍楼学员信息");
            System.out.println("7 . 宿舍学员信息");
            System.out.println("8 . 所有报修记录");
            System.out.println("9 . 未修报修记录");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 9);
            switch (choice) {
                case 1:
                    System.out.println(administrator);
                    break;
                case 2:
                    administratorBiz.lookAllStudents();
                    break;

                case 3:
                    System.out.println("请输入学号：");
                    int id0 = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Student s = studentDao.queryStudentById(id0);
                    if (s == null){
                        System.out.println("没有该学生！");
                        break;
                    }
                    administratorBiz.lookIdStudents(id0);
                    break;

                case 4:
                    System.out.println("————————————宿舍楼列表——————————");
                    List<Dormitory> dormitoryList = dormitoryDao.queryAllDormitorys();
                    for (Dormitory dormitory1 : dormitoryList) {
                        System.out.println(dormitory1);
                    }
                    System.out.println("————————————————————————————————");
                    System.out.println("请输入宿舍楼号");
                    int ssl2 = MyUtil.inputNum(0,100);
                    Dormitory dormitory = dormitoryDao.queryDormitoryById(ssl2);
                    if (dormitory == null){
                        System.out.println("`````````````````````````");
                        System.out.println("该宿舍楼不存在~~~");
                        System.out.println("`````````````````````````");
                        break;
                    }
                    administratorBiz.findNullBed(dormitory);
                    break;

                case 5:
                    System.out.println("请输入宿舍楼号");
                    int ssl3 = MyUtil.inputNum(0,100);
                    Dormitory dormitory3 = dormitoryDao.queryDormitoryById(ssl3);
                    if (dormitory3 == null){
                        System.out.println("`````````````````````````");
                        System.out.println("该宿舍楼不存在~~~");
                        System.out.println("`````````````````````````");
                        break;
                    }
                    System.out.println("请输入宿舍号");
                    int ss3 = MyUtil.inputNum(0,100);
                    Room room = roomDao.queryRoomById(ssl3,ss3);
                    if (room == null){
                        System.out.println("`````````````````````````");
                        System.out.println("该宿舍不存在~~~");
                        System.out.println("`````````````````````````");
                        break;
                    }
                    administratorBiz.findNullBedArray(room);
                    break;

                case 6:
                    System.out.println("请输入宿舍楼号");
                    int ssl6 = MyUtil.inputNum(0,100);
                    Dormitory dormitory6 = dormitoryDao.queryDormitoryById(ssl6);
                    if (dormitory6 == null){
                        System.out.println("`````````````````````````");
                        System.out.println("该宿舍楼不存在~~~");
                        System.out.println("`````````````````````````");
                        break;
                    }
                    System.out.println("~~~~~~~~~~~~~该楼学员信息~~~~~~~~~~~");
                    administratorBiz.lookDormitoryStudents(ssl6);
                    break;

                case 7:
                    System.out.println("请输入宿舍楼号");
                    int ssl7 = MyUtil.inputNum(0,100);
                    Dormitory dormitory7 = dormitoryDao.queryDormitoryById(ssl7);
                    if (dormitory7 == null){
                        System.out.println("`````````````````````````");
                        System.out.println("该宿舍楼不存在~~~");
                        System.out.println("`````````````````````````");
                        break;
                    }
                    System.out.println("请输入宿舍号");
                    int ss7 = MyUtil.inputNum(0,100);
                    Room room7 = roomDao.queryRoomById(ssl7,ss7);
                    if (room7 == null){
                        System.out.println("`````````````````````````");
                        System.out.println("该宿舍不存在~~~");
                        System.out.println("`````````````````````````");
                        break;
                    }
                    System.out.println("~~~~~~~~~~~~~该宿舍学员信息~~~~~~~~~~~");
                    administratorBiz.lookRoomStudents(ssl7,ss7);
                    break;

                case 8:
                    System.out.println("~~~~~~~~~~~~报修记录~~~~~~~~~~~~");
                    administratorBiz.lookRecords();
                    break;

                case 9:
                    System.out.println("~~~~~~~~~~~~未修报修记录~~~~~~~~~~~~");
                    administratorBiz.lookNotRecords();
                    break;

                case 0:
                    return; // 返回上一层
            }
        }while (true);
    }


    //授权入住迁出
    private static void in_out() {
        do {
            System.out.println();
            System.out.println("******** 授权迁出记录 ********");
            System.out.println("**** (1代表授权/0代表迁出) ****");
            administratorBiz.findCheck();
            System.out.println("******************************");
            System.out.println();
            System.out.println("------------------------------");
            System.out.println();
            System.out.println("***** 授权迁出 *****");
            System.out.println("1 . 授     权");
            System.out.println("2 . 入     住");
            System.out.println("3 . 迁     出");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 3);

            switch (choice) {
                case 1:
                    System.out.println("请输入授权学号");
                    int shudentId = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Student s = studentDao.queryStudentById(shudentId);
                    if (s == null){
                        System.out.println("没有该学生！");
                        break;
                    }
                    administratorBiz.addCheck(shudentId);
                    break;
                case 2:
                    System.out.println("请输入学号");
                    int id = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Student s01 = studentDao.queryStudentById(id);
                    if (s01 == null){
                        System.out.println("没有该学生！");
                        break;
                    }
                    Bed bed01 = bedDao.queryBedById(id);
                    if (bed01 != null){
                        System.out.println("该学生已入住！");
                        break;
                    }
                    String name01 = s01.getStudentName();
                    System.out.println("姓名:"+name01);
                    String sex01 = s01.getSex();
                    System.out.println("性别:"+sex01);
                    System.out.println("请输入宿舍楼号");
                    int ssl = MyUtil.inputNum(0,100);
                    System.out.println("请输入宿舍号");
                    int ss = MyUtil.inputNum(0,100);
                    System.out.println("请输入床位号");
                    int cw = MyUtil.inputNum(0,10);
                    Bed bed = new Bed(ssl,ss,cw,id);
                    boolean flag = administratorBiz.addBed(bed,sex01);
                    if (flag){
                        System.out.println("入住成功！");
                    }else {
                        System.out.println("入住失败！");
                    }
                    break;
                case 3:
                    System.out.println("请输入迁入单号");
                    int checkId = MyUtil.inputNum(0,Integer.MAX_VALUE);
                    Check c = checkDao.queryCheckById(checkId);
                    if (c == null){
                        System.out.println("迁出失败，没有授权记录！");
                        break;
                    }
                    int id3 = c.getStudentId();
                    System.out.println("学号:"+id3);
                    System.out.println("请确认是否迁出（1.是/2.否）");
                    int type = MyUtil.inputNum(1,2)-1;
                    Check check = new Check(checkId,id3,type);
                    administratorBiz.updateCheck(check);
                    break;
                case 0:
                    return; // 返回上一层
            }
        }while (true);
    }


    // 用户个人主页
    public static void studentView(StudentCard studentCard){
        do {
            System.out.println();
            System.out.println("***** 个人主页 *****");
            System.out.println("1 . 个人信息     ");
            System.out.println("2 . 修改密码     🔒");
            System.out.println("3 . 充值        💴");
            System.out.println("4 . 模拟消费     💸");
            System.out.println("5 . 余额提醒设置 🚨");
            System.out.println("6 . 报修单      🛠");
            System.out.println("7 . 设置密保信息 ");

            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 7);

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
                    char[] chars = CodeUtil.getCode();
                    String string = ""+chars[0]+chars[1]+chars[2]+chars[3];
                    System.out.println("请输入下列验证码:");
                    System.out.println("~~"+string+"~~");
                    String s = input.next();
                    if (!s.equals(string)){
                        System.out.println("验证码错误！");
                        break;
                    }
                    studentBiz.topIn(studentCard,money);
                    break;
                case 4:
                    shop(studentCard);
                    break;
                case 5:
                    System.out.println("请设置金额（0-1000元）");
                    int myMoney = MyUtil.inputNum(0,1000);
                    studentBiz.myRemind(studentCard,myMoney);
                    break;
                case 6:
                    studentRepair(studentCard);
                    break;
                case 7:
                    mySave(studentCard);
                    break;
                case 8:
                    System.out.println("没有写");
                    break;
                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }


    //密保设置
    private static void mySave(StudentCard studentCard) {
        System.out.println("请输入问题");
        String p = input.next();
        System.out.println("请输入答案");
        String a = input.next();
        Encrypted encrypted = new Encrypted(studentCard.getStudentId(),p,a);
        boolean fiag = encryptedDao.addEncrypted(encrypted);
        if (fiag){
            System.out.println("添加成功!");
        }else {
            System.out.println("添加失败！");
        }
    }


    private static void findMyAll(StudentCard studentCard) {
        //System.out.println("没有写");
        do{
            System.out.println();
            System.out.println("***** 个人信息 *****");
            System.out.println("1 . 充 值 信 息");
            System.out.println("2 . 学 生 信 息");
            System.out.println("3 . 学生卡信息");
            System.out.println("4 . 个人宿舍信息");
            System.out.println("5 . 个人密保信息");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 5);
            int studentId = studentCard.getStudentId();
            switch (choice) {
                case 1:
                    studentBiz.findTop();
                    break;
                case 2:
                    //System.out.println("没有写");
                    Student s = studentBiz.myStudent(studentId);
                    if (s == null){
                        System.out.println("😭");
                    }else {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    //System.out.println("没有写");
                    StudentCard sc = studentBiz.myStudentCard(studentId);
                    if (sc == null){
                        System.out.println("😭");
                    }else {
                        System.out.println(sc);
                    }
                    break;
                case 4:
                    //System.out.println("没有写");
                    Bed b = studentBiz.myBed(studentId);
                    if (b == null){
                        System.out.println("😭");
                    }else {
                        System.out.println(b);
                    }
                    break;
                case 5:
                    List<Encrypted> list = studentBiz.myAllEncrypted(studentId);
                    for (Encrypted encrypted : list) {
                        System.out.println(encrypted);
                    }
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
        if (studentCard.getPassword().equals(pass)){
            if (newPassword.equals(repeatPass)){
                studentBiz.newPass(studentCard,newPassword);
                System.out.println("修改成功！");
            }else {
                System.out.println("两次密码不一致，设置失败！");
            }
        }else {
            System.out.println("密码错误，请重新确认您的登陆密码！");
        }

    }


    //填写报修单
    private static void studentRepair(StudentCard studentCard) {
        //
        int studentId = studentCard.getStudentId();
        System.out.println("学号"+studentId);
        Bed bed = bedDao.queryBedById(studentId);
        if (bed == null){
            System.out.println("还没有住宿！");
            return;
        }
        int buildId = bedDao.queryBedById(studentId).getBuildId();
        System.out.println("宿舍楼号："+buildId);
        int roomId = bedDao.queryBedById(studentId).getRoomId();
        System.out.println("宿舍号："+roomId);
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
            System.out.println("4 . 网费（50元/月）");
            System.out.println("0 . 返回上一层");
            System.out.println("请选择编号：");
            int choice = MyUtil.inputNum(0, 4);
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
                case 4:
                    studentBiz.topOut(studentCard,50);
                    break;
                case 0:
                    return; // 返回上一层
            }
        }while(true);
    }
}
