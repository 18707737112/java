package com.iotek.dao;

import com.iotek.dao.impl.CheckDaoImpl;
import com.iotek.entity.Check;
import org.junit.Test;

import java.util.List;


public class CheckDaoTest {
    private CheckDao checkDao = new CheckDaoImpl();

    @Test
    public void findAll(){
        List<Check> list = checkDao.queryAllCheckS();
        for (Check check : list) {
            System.out.println(check);
        }
    }

    @Test
    public void add(){
        Check check = new Check(1);
        checkDao.addCheck(check);

        findAll();
    }

    @Test
    public void del(){
        checkDao.delCheck(3);

        findAll();
    }

    @Test
    public void up(){
        Check check = new Check(1,1,0);
        checkDao.updateCheck(check);

        findAll();
    }

    @Test
    public void find(){
        Check check = checkDao.queryCheckById(1);

        System.out.println(check);
    }
}
