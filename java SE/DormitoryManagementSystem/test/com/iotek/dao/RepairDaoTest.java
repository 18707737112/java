package com.iotek.dao;

import com.iotek.dao.impl.RepairDaoImpl;
import com.iotek.entity.Repair;
import org.junit.Test;

import java.util.List;

public class RepairDaoTest {
    private RepairDao repairDao = new RepairDaoImpl();

    @Test
    public void findAll(){
        List<Repair> list = repairDao.queryAllRepairs();
        for (Repair repair : list) {
            System.out.println(repair);
        }
    }

    @Test
    public void add(){
        Repair repair = new Repair(1,1,1,"桌子");
        repairDao.addRepair(repair);
        findAll();
    }

    @Test
    public void del(){
        repairDao.delRepair(3);
        findAll();
    }

    @Test
    public void update(){
        Repair repair = new Repair(3,1,1,1,"桌子",1);
        repairDao.updateRepair(repair);
        findAll();
    }

    @Test
    public void findId(){
        Repair repair = repairDao.queryRepairById(3);
        System.out.println(repair);
    }

    @Test
    public void findIdS(){
        List<Repair> list= repairDao.queryRepairByIdS(1);
        for (Repair repair : list) {
            System.out.println(repair);
        }
    }
}
