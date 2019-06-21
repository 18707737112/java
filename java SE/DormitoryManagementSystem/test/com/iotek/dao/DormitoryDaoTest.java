package com.iotek.dao;

import com.iotek.dao.impl.DormitoryDaoImpl;
import com.iotek.entity.Dormitory;
import org.junit.Test;

import java.util.List;

public class DormitoryDaoTest {
    private DormitoryDao dormitoryDao = new DormitoryDaoImpl();

    @Test
    public void findAll(){
        List<Dormitory> list = dormitoryDao.queryAllDormitorys();
        for (Dormitory dormitory : list) {
            System.out.println(dormitory);
        }
    }

    @Test
    public void add(){
        dormitoryDao.addDormitory(new Dormitory("男",2));
        findAll();
    }

    @Test
    public void del(){
        dormitoryDao.delDormitory(2);
        findAll();
    }

    @Test
    public void findId(){

        System.out.println(dormitoryDao.queryDormitoryById(1));

    }

    @Test
    public void up(){
        Dormitory d = new Dormitory(1,"女",2);
        dormitoryDao.updateDormitoryCard(d);
        findAll();
    }
}
