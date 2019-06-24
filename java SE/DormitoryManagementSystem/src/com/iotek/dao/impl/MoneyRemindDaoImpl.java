package com.iotek.dao.impl;

import com.iotek.dao.MoneyRemindDao;
import com.iotek.entity.MoneyRemind;

import java.io.File;
import java.util.List;

public class MoneyRemindDaoImpl extends BaseDaoImpl implements MoneyRemindDao {
    private File moneyRemindFile = new File("file/moneyRemind.dat");

    @Override
    public boolean addMoneyRemind(MoneyRemind moneyRemind) {
        List<MoneyRemind> mList = read(moneyRemindFile);
        if (moneyRemind == null){
            return false;
        }

        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).getId()==moneyRemind.getId()){
                mList.set(i,moneyRemind);
                return  write(mList,moneyRemindFile);
            }
        }
        mList.add(moneyRemind);
        return  write(mList,moneyRemindFile);
    }

    @Override
    public MoneyRemind queryMoneyRemindById(int id) {
        List<MoneyRemind> mList = read(moneyRemindFile);
        /*for (int i = 0; i < mList.size(); i++) {
            MoneyRemind m = mList.get(i);
            if (m.getId()==id){
                return m;
            }
        }*/
        for (MoneyRemind m : mList) {
            if(m.getId() == id){
                return m;
            }
        }
        MoneyRemind moneyRemind = new MoneyRemind(id,0);
        boolean fiag = addMoneyRemind(moneyRemind);
        if (fiag){
            return new MoneyRemind(id,0);
        }
        return null;
    }

    @Override
    public List<MoneyRemind> queryAllMoneyReminds(){
        return read(moneyRemindFile);
    }
}
