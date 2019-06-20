package com.iotek.biz.impl;

import com.iotek.biz.StudentBiz;
import com.iotek.dao.StudentCardDao;
import com.iotek.dao.StudentDao;
import com.iotek.dao.impl.StudentCardDaoImpl;
import com.iotek.dao.impl.StudentDaoImpl;
import com.iotek.entity.Administrator;
import com.iotek.entity.StudentCard;

import java.util.List;

public class StudentBizImpl implements StudentBiz {
    private StudentCardDao studentCardDao = new StudentCardDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean register(StudentCard studentCard) {
        // 先看一下用户名是否存在
        List<StudentCard> sList = studentCardDao.queryAllStudentCards();
        for (StudentCard s : sList) {
            if(s.getStudentId()==studentCard.getStudentId()){
                // 已存在
                System.err.println("用户名已存在，是否要登录？");
                return false;
            }
        }
        // 如果用户名不存在，则说明该用户名可用
        return studentCardDao.addStudentCard(studentCard);
    }

    @Override
    public StudentCard login(StudentCard studentCard) {
        StudentCard s = studentCardDao.queryStudentCardByNameAndPassword(studentCard.getStudentId(),studentCard.getPassword());
        return s;
    }

    //可放在视图层
    @Override
    public void topIn(StudentCard studentCard, double money) {
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
    }

    //可放在视图层
    @Override
    public void topOut(StudentCard studentCard, double money) {
        if(money<0){
            System.err.println("金额不能为负，付款失败！");
            return;
        }
        double useMoney = studentCard.getMoney()-200;
        money = studentCard.getMoney() - money;
        studentCard.setMoney(money);
        if (money<200){
            System.out.println("付款未成功！");
            System.err.println("亲，押金200喲！😊😊😊😊😊😊");
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
    }
}
