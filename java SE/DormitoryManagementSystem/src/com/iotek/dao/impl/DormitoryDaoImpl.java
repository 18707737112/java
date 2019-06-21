package com.iotek.dao.impl;

import com.iotek.dao.DormitoryDao;
import com.iotek.entity.Dormitory;

import java.io.File;
import java.util.List;

public class DormitoryDaoImpl extends BaseDaoImpl<Dormitory> implements DormitoryDao {
    private File domitoryFile = new File("file/dormitory.dat");


    @Override
    public boolean addDormitory(Dormitory dormitory) {
        List<Dormitory> dList = read(domitoryFile);

        if (dormitory.getBuildId() == 0){
            if(dList.size() == 0){
                dormitory.setBuildId(1);
            }else{
                int newId = dList.get(dList.size()-1).getBuildId()+1;
                dormitory.setBuildId(newId);
            }
            dList.add(dormitory);

            return write(dList,domitoryFile);
        }

        for (Dormitory d : dList) {
            if (d.getBuildId() == dormitory.getBuildId()){
                return false;
            }
        }

        dList.add(dormitory);
        return write(dList,domitoryFile);

        /*List<Dormitory> dList = read(domitoryFile);
        for (Dormitory d : dList) {
            if (d.getBuildId() == dormitory.getBuildId()){
                return false;
            }
        }
        dList.add(dormitory);
        return write(dList,domitoryFile);*/
    }

    @Override
    public boolean delDormitory(int buildIdId) {
        List<Dormitory> dList = read(domitoryFile);
        for (int i = 0; i < dList.size(); i++) {
            Dormitory d = dList.get(i);
            if(d.getBuildId() == buildIdId){
                dList.remove(i);
                return write(dList,domitoryFile);
            }
        }
        return false;
    }

    @Override
    public boolean updateDormitoryCard(Dormitory dormitory) {
        List<Dormitory> dList = read(domitoryFile);
        for (int i = 0; i < dList.size(); i++) {
            Dormitory d = dList.get(i);
            if(d.getBuildId() == dormitory.getBuildId()){
                dList.set(i,dormitory);
                return write(dList,domitoryFile);
            }
        }
        return false;
    }

    @Override
    public Dormitory queryDormitoryById(int buildId) {
        List<Dormitory> dList = read(domitoryFile);
        for (int i = 0; i < dList.size(); i++) {
            Dormitory d = dList.get(i);
            if (d.getBuildId()==buildId){
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Dormitory> queryAllDormitorys() {
        return read(domitoryFile);
    }
}
