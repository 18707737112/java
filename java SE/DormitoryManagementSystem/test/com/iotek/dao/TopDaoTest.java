package com.iotek.dao;

import com.iotek.dao.impl.TopDaoImpl;
import com.iotek.entity.Top;
import org.junit.Test;

import java.util.List;

public class TopDaoTest {
    private TopDao topDao = new TopDaoImpl();

    @Test
    public void findAll(){
        List<Top> list = topDao.queryAllTops();

        for (Top top : list) {
            System.out.println(top);
        }
    }

    @Test
    public void add(){
        Top top = new Top(1,10);
        topDao.addTop(top);
        findAll();
    }

}
