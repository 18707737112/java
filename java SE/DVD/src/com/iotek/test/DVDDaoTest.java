package com.iotek.test;

import com.iotek.dao.DVDDao;
import com.iotek.dao.impl.DVDDaoImpl;
import com.iotek.entity.DVD;
import org.junit.Test;

public class DVDDaoTest {
    private DVDDao dvdDao = new DVDDaoImpl();
    @Test
    public void testSaveDVD(){
        dvdDao.saveDVD(new DVD("三国演义",0,0));
    }

    @Test
    public void testQueryDVDs(){
        for (DVD dvd : dvdDao.queryDVDs()) {
            System.out.println(dvd);
        }
    }
}
