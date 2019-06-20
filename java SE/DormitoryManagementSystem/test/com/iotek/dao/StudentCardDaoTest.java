package com.iotek.dao;

import com.iotek.dao.impl.StudentCardDaoImpl;
import com.iotek.entity.StudentCard;
import org.junit.Test;

public class StudentCardDaoTest {
    private StudentCardDao studentCardDao = new StudentCardDaoImpl();

    @Test
    public void findAll(){
        System.out.println(studentCardDao.queryAllStudentCards());
    }

    @Test
    public void add(){
        studentCardDao.addStudentCard(new StudentCard(2,"不知道","1","妖",100));
        findAll();
    }

    @Test
    public void del(){
        studentCardDao.delStudentCard(1);
        findAll();
    }

    @Test
    public void up(){
        studentCardDao.updateStudentCard(new StudentCard(1,"111"));
        findAll();
    }

    @Test
    public void qId(){
        StudentCard s = studentCardDao.queryStudentCardById(1);
        System.out.println(s);
    }

    @Test
    public void login(){
        StudentCard s = studentCardDao.queryStudentCardByNameAndPassword(2,"1");
        System.out.println(s);
    }
}
