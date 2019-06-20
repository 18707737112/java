package com.iotek.biz.impl;

import com.iotek.biz.AdministratorBiz;
import com.iotek.dao.AdministratorDao;
import com.iotek.dao.StudentDao;
import com.iotek.dao.impl.AdministratorDaoImpl;
import com.iotek.dao.impl.StudentDaoImpl;
import com.iotek.entity.Administrator;
import com.iotek.entity.Student;

import java.util.List;

public class AdministratorBizImpl implements AdministratorBiz {
    private AdministratorDao administratorDao = new AdministratorDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean register(Administrator administrator) {
        // 先看一下用户名是否存在
        List<Administrator> aList = administratorDao.queryAllAdministrators();
        for (Administrator a : aList) {
            if(a.getAdministratorName().equals(administrator.getAdministratorName())){
                // 已存在
                System.err.println("用户名已存在，是否要登录？");
                return false;
            }
        }
        // 如果用户名不存在，则说明该用户名可用
        return administratorDao.addAdministrator(administrator);
    }

    @Override
    public Administrator login(Administrator administrator) {
        Administrator a = administratorDao.queryAdministratorByNameAndPassword(administrator.getAdministratorName(),administrator.getAdministratorPass());
        return a;
    }

    @Override
    public void lookAllStudents() {
        List<Student> sList = studentDao.queryAllStudents();
        for (Student student : sList) {
            System.out.println(student);
        }
    }
}
