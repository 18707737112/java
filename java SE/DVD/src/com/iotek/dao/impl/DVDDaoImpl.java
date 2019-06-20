package com.iotek.dao.impl;

import com.iotek.dao.DVDDao;
import com.iotek.entity.DVD;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DVDDaoImpl extends BaseDaoImpl<DVD> implements DVDDao {
    private File dvdFile = new File("file/dvd.dat");

    @Override
    public boolean saveDVD(DVD dvd) {
        List<DVD> dList = read(dvdFile);
        if(dList.size() == 0){
            dvd.setId(1);
        }else{
            int newId =dList.get(dList.size()-1).getId()+1;
            dvd.setId(newId);
        }
        dList.add(dvd);

        return write(dList,dvdFile);
    }

    @Override
    public boolean updateDVD(DVD dvd) {
        List<DVD> dList = read(dvdFile);
        for (int i = 0; i < dList.size(); i++) {
            DVD d = dList.get(i);
            if(d.getId() == dvd.getId()){
                dList.set(i,dvd);
                return write(dList,dvdFile);
            }
        }
        return false;
    }

    @Override
    public boolean delDVD(int did) {
        List<DVD> dList = read(dvdFile);
        for (int i = 0; i < dList.size(); i++) {
            DVD d = dList.get(i);
            if(d.getId() == did){
                dList.remove(i);
                return write(dList,dvdFile);
            }
        }
        return false;
    }

    @Override
    public List<DVD> queryDVDs() {
        return read(dvdFile);
    }

    @Override
    public List<DVD> queryDVDByName(String dname) {
        List<DVD> dList = read(dvdFile);
        List<DVD> newList = new ArrayList<>();
        for (DVD d : dList) {
            if(d.getDname().equals(dname)){
                newList.add(d);
            }
        }
        return newList;
    }

    @Override
    public List<DVD> querySortDVDByLimit(int index, int number) {
        List<DVD> dList = read(dvdFile);
        Collections.sort(dList,(d1,d2)->d2.getDcount()-d1.getDcount()); // 根据借出次数降序排序
        return dList.subList(index,number);
    }

    @Override
    public DVD queryDVDById(int did) {
        List<DVD> dList = read(dvdFile);
        for (DVD d : dList) {
            if(d.getId() == did){
                return d;
            }
        }
        return null;
    }

    @Override
    public List<DVD> queryDVDByStatus(int status) {
        List<DVD> dList = read(dvdFile);
        List<DVD> newList = new ArrayList<>();
        for (DVD d : dList) {
            if(d.getStatus() == status){
                newList.add(d);
            }
        }
        return newList;
    }
}
