package com.iotek.biz.impl;

import com.iotek.biz.StudentBiz;
import com.iotek.dao.*;
import com.iotek.dao.impl.*;
import com.iotek.entity.*;

import java.util.List;

public class StudentBizImpl implements StudentBiz {
    private StudentCardDao studentCardDao = new StudentCardDaoImpl();
    private BedDao bedDao = new BedDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private RepairDao repairDao = new RepairDaoImpl();
    private EncryptedDao encryptedDao = new EncryptedDaoImpl();
    private MoneyRemindDao moneyRemindDao = new MoneyRemindDaoImpl();
    private TopDao topDao = new TopDaoImpl();

    @Override
    public boolean register(StudentCard studentCard) {
        // 先看一下用户名是否存在
        List<Student> studentList = studentDao.queryAllStudents();
        List<StudentCard> sList = studentCardDao.queryAllStudentCards();
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
        StudentCard s = studentCardDao.queryStudentCardByNameAndPassword(studentCard.getStudentId(),studentCard.getPassword());
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
        double useMoney = studentCard.getMoney()-200;
        money = studentCard.getMoney() - money;
        studentCard.setMoney(money);
        if (money<200){
            System.out.println("付款未成功！");
            System.out.println("亲，押金200喲！😊😊😊😊😊😊");
            System.out.println("您的可用余额："+useMoney);
            System.out.println("您的卡中可用余额已不足支付，请及时充值！");
            return;
        }
        boolean flay = studentCardDao.updateStudentCard(studentCard);
        if (!flay){
            System.out.println("付款未成功，请重新操作！");
            return;
        }
        System.out.println("付款成功！");
        System.out.println("余额："+studentCard.getMoney());
        System.out.println("押金200");
        System.out.println("可用余额："+(studentCard.getMoney()-200));
        if (myMoney>(studentCard.getMoney()-200)){
            System.out.println("您的卡中可用余额已不足"+myMoney+"，请及时充值！");
        }
    }

    @Override
    public void myRemind(StudentCard studentCard,int money) {
        int id = studentCard.getStudentId();
        MoneyRemind moneyRemind = moneyRemindDao.queryMoneyRemindById(id);
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
        return studentCardDao.queryStudentCardById(studentId);
    }

    @Override
    public Bed myBed(int studentId) {
        return bedDao.queryBedById(studentId);
    }

}
