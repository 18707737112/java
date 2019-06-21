package com.iotek.dao;

import com.iotek.dao.impl.BedDaoImpl;
import com.iotek.entity.Bed;
import org.junit.Test;

import java.util.List;

public class BedDaoTest {
    private BedDao bedDao = new BedDaoImpl();

    @Test
    public void findAll(){
        List<Bed> list = bedDao.queryAllBeds();

        for (Bed bed : list) {
            System.out.println(bed);
        }
    }

    @Test
    public void add(){
        Bed bed1 = new Bed(1,2,1);
        Bed bed2 = new Bed(1,2,2);
        Bed bed3 = new Bed(1,2,3);
        Bed bed4 = new Bed(1,2,4);
        Bed bed5 = new Bed(1,2,5);
        Bed bed6 = new Bed(1,2,6);
        bedDao.addBed(bed1);
        bedDao.addBed(bed2);
        bedDao.addBed(bed3);
        bedDao.addBed(bed4);
        bedDao.addBed(bed5);
        bedDao.addBed(bed6);
        findAll();
    }

    @Test
    public void del(){
        bedDao.delBed(1);
        findAll();
    }

    @Test
    public void up(){
        Bed bed = new Bed(1,2,6,1);
        bedDao.updateBed(bed);
        findAll();
    }

    @Test
    public void findId(){
        Bed bed = bedDao.queryBedById(6);

        System.out.println(bed);
    }
}
