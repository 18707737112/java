package com.iotek.dao.impl;

import com.iotek.dao.BedDao;
import com.iotek.entity.Bed;

import java.io.File;
import java.util.List;

public class BedDaoImpl extends BaseDaoImpl<Bed> implements BedDao {
    private File bedFile = new File("file/bed.dat");


    @Override
    public boolean addBed(Bed bed) {
        List<Bed> bedList = read(bedFile);

        for (Bed b : bedList) {
            if (b.getBedId() == bed.getBedId()
            && b.getRoomId() == bed.getRoomId()
            && b.getBuildId() == bed.getBuildId()){
                return false;
            }
        }

        bedList.add(bed);
        return write(bedList,bedFile);

    }

    @Override
    public boolean delBed(int bedId) {
        List<Bed> list = read(bedFile);
        for (int i = 0; i < list.size(); i++) {
            Bed b = list.get(i);
            if(b.getBedId() == bedId){
                list.remove(i);
                return write(list,bedFile);
            }
        }
        return false;
    }

    @Override
    public boolean updateBed(Bed bed) {
        List<Bed> dList = read(bedFile);
        for (int i = 0; i < dList.size(); i++) {
            Bed d = dList.get(i);
            if(d.getBedId() == bed.getBedId()
            && d.getRoomId() == bed.getRoomId()
            && d.getBuildId() == bed.getBuildId()){
                dList.set(i,bed);
                return write(dList,bedFile);
            }
        }
        System.out.println("该床位不存在！");
        return false;
    }

    @Override
    public Bed queryBedById(int studentId) {
        List<Bed> dList = read(bedFile);
        for (int i = 0; i < dList.size(); i++) {
            Bed d = dList.get(i);
            if (d.getStudentId()==studentId){
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Bed> queryAllBeds() {
        return read(bedFile);
    }
}
