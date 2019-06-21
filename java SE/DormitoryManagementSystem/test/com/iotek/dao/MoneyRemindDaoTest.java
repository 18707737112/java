package com.iotek.dao;

import com.iotek.dao.impl.MoneyRemindDaoImpl;
import com.iotek.entity.MoneyRemind;
import org.junit.Test;

import java.util.List;

public class MoneyRemindDaoTest {
    private MoneyRemindDao moneyRemindDao = new MoneyRemindDaoImpl();

    @Test
    public void findAll(){
        List<MoneyRemind> list = moneyRemindDao.queryAllMoneyReminds();
        for (MoneyRemind moneyRemind : list) {
            System.out.println(moneyRemind);
        }
    }

    @Test
    public void add(){
        MoneyRemind m = new MoneyRemind(0,0);
        moneyRemindDao.addMoneyRemind(m);
        findAll();
    }
}
