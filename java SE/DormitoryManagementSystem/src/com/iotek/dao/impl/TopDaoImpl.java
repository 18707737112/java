package com.iotek.dao.impl;

import com.iotek.dao.TopDao;
import com.iotek.entity.Top;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TopDaoImpl extends BaseDaoImpl<Top> implements TopDao {
    private File topFile = new File("file/top.dat");

    @Override
    public boolean addTop(Top top) {
        List<Top> tList = read(topFile);
        tList.add(top);
        return write(tList,topFile);
    }

    @Override
    public boolean delTop(int studentId) {
        List<Top> tList = read(topFile);
        for (int i = 0; i < tList.size(); i++) {
            Top t = tList.get(i);
            if(t.getStudentId() == studentId){
                tList.remove(i);
            }
        }
        return write(tList,topFile);
    }

    @Override
    public boolean updateTop(Top top) {
        List<Top> tList = read(topFile);
        for (int i = 0; i < tList.size(); i++) {
            Top t = tList.get(i);
            if(t.getStudentId() == top.getStudentId()){
                tList.set(i,top);
                return write(tList,topFile);
            }
        }
        return false;
    }

    @Override
    public List<Top> queryTopById(int studentId) {
        List<Top> tList = read(topFile);
        List<Top> newList = new ArrayList<>();
        for (int i = 0; i < tList.size(); i++) {
            Top t = tList.get(i);
            if (t.getStudentId()==studentId){
                newList.add(t);
            }
        }
        return newList;
    }

    @Override
    public List<Top> queryAllTops() {
        return read(topFile);
    }
}
