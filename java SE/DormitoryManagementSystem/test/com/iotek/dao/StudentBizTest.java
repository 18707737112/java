package com.iotek.dao;

import com.iotek.biz.StudentBiz;
import com.iotek.biz.impl.StudentBizImpl;
import com.iotek.entity.StudentCard;
import org.junit.Test;

public class StudentBizTest {
    private StudentBiz studentBiz = new StudentBizImpl();

    @Test
    public void loginTest(){
        StudentCard s = studentBiz.login(new StudentCard(2,"1"));
        System.out.println(s);
    }

    @Test
    public void reg(){
        boolean flat = studentBiz.register(new StudentCard(1,"111"));
        System.out.println(flat);
    }

    @Test
    public void money(){
        studentBiz.topIn(new StudentCard(2,"不知道","1","妖",100),10);
        studentBiz.topOut(new StudentCard(2,"不知道","1","妖",100),20);
    }
}
