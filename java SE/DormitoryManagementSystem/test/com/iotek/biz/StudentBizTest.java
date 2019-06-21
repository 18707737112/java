package com.iotek.biz;

import com.iotek.biz.StudentBiz;
import com.iotek.biz.impl.StudentBizImpl;
import com.iotek.dao.EncryptedDaoTest;
import com.iotek.dao.RepairDao;
import com.iotek.dao.impl.RepairDaoImpl;
import com.iotek.entity.Encrypted;
import com.iotek.entity.Repair;
import com.iotek.entity.StudentCard;
import org.junit.Test;

import java.util.List;

public class StudentBizTest {
    private StudentBiz studentBiz = new StudentBizImpl();
    private RepairDao repairDao = new RepairDaoImpl();
    private EncryptedDaoTest encryptedDaoTest = new EncryptedDaoTest();

    @Test
    public void findAllRepairs(){
        List<Repair> list = repairDao.queryAllRepairs();
        for (Repair repair : list) {
            System.out.println(repair);
        }
    }

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

    @Test
    public void repair(){
        Repair r = new Repair(2,1,1,"桌子");
        System.out.println(studentBiz.theRepair(r));
        findAllRepairs();
    }

    @Test
    public void addEncrypted(){
        Encrypted e1 = new Encrypted(1,"1","1");
        Encrypted e2 = new Encrypted(1,"2","2");
        Encrypted e3 = new Encrypted(1,"3","3");
        studentBiz.addOneEncrypted(e1);
        studentBiz.addOneEncrypted(e2);
        studentBiz.addOneEncrypted(e3);
        encryptedDaoTest.findAll();
    }
}
