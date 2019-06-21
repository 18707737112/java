package com.iotek.dao;

import com.iotek.entity.MoneyRemind;

import java.util.List;

public interface MoneyRemindDao {
    boolean addMoneyRemind(MoneyRemind moneyRemind);
    MoneyRemind queryMoneyRemindById(int id);
    List<MoneyRemind> queryAllMoneyReminds();
}
