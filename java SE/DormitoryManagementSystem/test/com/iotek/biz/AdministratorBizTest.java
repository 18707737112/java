package com.iotek.biz;

import com.iotek.biz.AdministratorBiz;
import com.iotek.biz.impl.AdministratorBizImpl;
import com.iotek.dao.impl.AdministratorDaoImpl;
import com.iotek.entity.Administrator;
import org.junit.Test;

import java.util.List;

public class AdministratorBizTest {

    private AdministratorBiz administratorBiz = new AdministratorBizImpl();

    @Test
    public void loginTest(){
        Administrator a = administratorBiz.login(new Administrator("aaa","aaa"));
        System.out.println(a);
    }

    @Test
    public void lookStudentTest(){
        administratorBiz.lookAllStudents();
    }

}


