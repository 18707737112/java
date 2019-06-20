package com.iotek.dao.impl;

import com.iotek.dao.RepairDao;
import com.iotek.entity.Repair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RepairDaoImpl extends BaseDaoImpl<Repair> implements RepairDao {
    private File repairFile = new File("file/repair.dat");

    @Override
    public boolean addRepair(Repair repair) {
        List<Repair> rList = read(repairFile);

        if(rList.size() == 0){
            repair.setRepairId(1);
        }else{
            int newId = rList.get(rList.size()-1).getRepairId()+1;
            repair.setRepairId(newId);
        }
        rList.add(repair);

        return write(rList,repairFile);
    }

    @Override
    public boolean delRepair(int repairId) {
        List<Repair> rList = read(repairFile);
        for (int i = 0; i < rList.size(); i++) {
            Repair r = rList.get(i);
            if(r.getRepairId() == repairId){
                rList.remove(i);
                return write(rList,repairFile);
            }
        }
        return false;
    }

    @Override
    public boolean updateRepair(Repair repair) {
        List<Repair> rList = read(repairFile);
        for (int i = 0; i < rList.size(); i++) {
            Repair r = rList.get(i);
            if(r.getRepairId() == repair.getRepairId()){
                rList.set(i,repair);
                return write(rList,repairFile);
            }
        }
        return false;
    }

    @Override
    public Repair queryRepairById(int repairId) {
        List<Repair> rList = read(repairFile);
        for (int i = 0; i < rList.size(); i++) {
            Repair r = rList.get(i);
            if (r.getRepairId()==repairId){
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Repair> queryRepairByIdS(int studentId) {
        List<Repair> rList = read(repairFile);
        List<Repair> newList = new ArrayList<>();
        for (int i = 0; i < rList.size(); i++) {
            Repair r = rList.get(i);
            if (r.getStudentId()==studentId){
                newList.add(r);
            }
        }
        return newList;
    }

    @Override
    public List<Repair> queryAllRepairs() {
        return read(repairFile);
    }
}
