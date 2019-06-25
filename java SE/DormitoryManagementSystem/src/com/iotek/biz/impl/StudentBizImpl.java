package com.iotek.biz.impl;

import com.iotek.biz.StudentBiz;
import com.iotek.dao.*;
import com.iotek.dao.impl.*;
import com.iotek.entity.*;

import java.util.List;
import java.util.Scanner;

public class StudentBizImpl implements StudentBiz {
    private StudentCardDao studentCardDao = new StudentCardDaoImpl();
    private BedDao bedDao = new BedDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private RepairDao repairDao = new RepairDaoImpl();
    private EncryptedDao encryptedDao = new EncryptedDaoImpl();
    private MoneyRemindDao moneyRemindDao = new MoneyRemindDaoImpl();
    private TopDao topDao = new TopDaoImpl();
    private CheckDao checkDao = new CheckDaoImpl();

    @Override
    public boolean register(StudentCard studentCard) {
        // 先看一下用户名是否存在
        List<Student> studentList = studentDao.queryAllStudents();
        List<StudentCard> sList = studentCardDao.queryAllStudentCards();
        List<Check> cL = checkDao.queryCheckByIdS(studentCard.getStudentId());
        Check c;
        if (cL == null || cL.size()==0){
            System.out.println("没有授权，不能注册~~~~~~~~~~");
            return false;
        }else {
            c = cL.get(cL.size()-1);
            if (c.getType() == 0){
                System.out.println("没有授权，不能注册~~~~~~~~~~");
                return false;
            }
        }
        for (StudentCard s : sList) {
            if(s.getStudentId()==studentCard.getStudentId()){
                // 已存在
                System.err.println("用户名已存在，是否要登录？");
                return false;
            }
        }
        for (Student student : studentList) {
            if (student.getStudentId() == studentCard.getStudentId()){
                // 如果用户名不存在，则说明该用户名可用(该学号必须存在)
                return studentCardDao.addStudentCard(studentCard);
            }
        }
        System.out.println("学号不存在！");
        System.out.println("亲，只有在校生才能注册哟~~~");
        return false;
    }

    @Override
    public StudentCard login(StudentCard studentCard) {
        if (studentCard == null){
            return null;
        }
        StudentCard s = studentCardDao.queryStudentCardByNameAndPassword(studentCard.getStudentId(),studentCard.getPassword());
        if (s == null){
            return null;
        }
        List<Check> cL = checkDao.queryCheckByIdS(s.getStudentId());
        Check c;
        if (cL == null || cL.size()==0){
            System.out.println("未授权~");
            return null;
        }else {
            c = cL.get(cL.size()-1);
            if(c.getType() == 0){
                System.out.println("已迁出~~~");
                return null;
            }
        }
        return s;
    }

    @Override
    public boolean newPass(StudentCard studentCard,String pass) {
        studentCard.setPassword(pass);
        return studentCardDao.updateStudentCard(studentCard);
    }

    //可放在视图层
    @Override
    public void topIn(StudentCard studentCard, double money) {
        double num = money;
        if(money<0){
            System.err.println("金额不能为负，充值失败！");
            return;
        }
        money += studentCard.getMoney();
        studentCard.setMoney(money);
        boolean flay = studentCardDao.updateStudentCard(studentCard);
        if (!flay){
            System.out.println("充值未成功，请重新操作！");
            return;
        }
        System.out.println("充值成功！");
        System.out.println("余额："+studentCard.getMoney());
        System.out.println("押金200");
        System.out.println("可用余额："+(studentCard.getMoney()-200));
        Top top = new Top(studentCard.getStudentId(),num);
        flay = topDao.addTop(top);
        if (!flay){
            System.out.println("记录录入失败！");
        }
    }

    //可放在视图层
    @Override
    public void topOut(StudentCard studentCard, double money) {
        int id = studentCard.getStudentId();
        double myMoney = moneyRemindDao.queryMoneyRemindById(id).getMoney();

        if(money<0){
            System.err.println("金额不能为负，付款失败！");
            return;
        }
        if(money>100){
            Scanner scanner = new Scanner(System.in);
            System.out.println("支付金额超过100，为了您的资金安全，请输入支付密码：");
            String string = scanner.next();
            if (!string.equals(studentCard.getPassword())){
                System.out.println("密码错误！");
                System.out.println("付款未成功，请重新操作！");
                return;
            }
        }
        double useMoney = studentCard.getMoney()-200;
        money = studentCard.getMoney() - money;
        if (money<200){
            System.out.println("付款未成功！");
            System.out.println("亲，押金200喲！😊😊😊😊😊😊");
            System.out.println("您的可用余额："+useMoney);
            System.out.println("您的卡中可用余额已不足支付，请及时充值！");
            return;
        }
        studentCard.setMoney(money);
        boolean flay = studentCardDao.updateStudentCard(studentCard);
        if (!flay){
            System.out.println("付款未成功，请重新操作！");
            return;
        }
        System.out.println("付款成功！");
        System.out.println("余额："+studentCard.getMoney());
        System.out.println("押金200,迁出退款！");
        System.out.println("可用余额："+(studentCard.getMoney()-200));
        if (myMoney>(studentCard.getMoney()-200)){
            System.out.println("您的卡中可用余额已不足"+myMoney+"，请及时充值！");
        }
    }

    @Override
    public void myRemind(StudentCard studentCard,int money) {
        int id = studentCard.getStudentId();
        MoneyRemind moneyRemind = moneyRemindDao.queryMoneyRemindById(id);
        moneyRemind.setMoney(money);
        boolean fiag = moneyRemindDao.addMoneyRemind(moneyRemind);
        if (fiag){
            System.out.println("设置成功！");
            System.out.println("您的余额提醒为："+moneyRemind.getMoney());
        }else {
            System.out.println("设置失败！");
        }
    }

    @Override
    public boolean theRepair(Repair repair) {
        return repairDao.addRepair(repair);
    }

    @Override
    public boolean addOneEncrypted(Encrypted encrypted) {
        return encryptedDao.addEncrypted(encrypted);
    }

    @Override
    public List<Encrypted> myAllEncrypted(int id) {
        return encryptedDao.queryEncryptedById(id);
    }

    @Override
    public Student myStudent(int studentId) {
        return studentDao.queryStudentById(studentId);
        //return null;
    }

    @Override
    public StudentCard myStudentCard(int studentId) {
        StudentCard studentCard = studentCardDao.queryStudentCardById(studentId);
        Student student = studentDao.queryStudentById(studentId);
        studentCard.setStudetName(student.getStudentName());
        studentCard.setSex(student.getSex());
        return studentCard;
    }

    @Override
    public Bed myBed(int studentId) {
        return bedDao.queryBedById(studentId);
    }

    @Override
    public void findTop() {
        List<Top> list = topDao.queryAllTops();
        for (Top top : list) {
            System.out.println(top);
        }
    }

}
