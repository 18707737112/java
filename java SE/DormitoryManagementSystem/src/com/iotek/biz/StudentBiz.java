package com.iotek.biz;

import com.iotek.entity.*;

import java.util.List;
import java.util.Random;

public interface StudentBiz {
    boolean register(StudentCard studentCard); // 1.注册
    StudentCard login(StudentCard studentCard); //2.登录
    boolean newPass(StudentCard studentCard,String pass);//3.修改密码
    void topIn(StudentCard studentCard,double money);//4.充值
    void topOut(StudentCard studentCard,double money);//5.消费
    void myRemind(StudentCard studentCard,int money);//6.自定义余额提醒
    boolean theRepair(Repair repair);//7.报修
    boolean addOneEncrypted(Encrypted encrypted);//8.添加一个密保
    //Encrypted myEncrypted(int id);//随机生成一个密保
    List<Encrypted> myAllEncrypted(int id);//9.查询自己的密保(随机生成一个密保)
    Student myStudent(int studentId);//学生信息
    StudentCard myStudentCard(int studentId);//学生卡信息
    Bed myBed(int studentId);//宿舍信息



}
