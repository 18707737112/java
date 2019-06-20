package com.iotek.dao;

import com.iotek.entity.DVD;

import java.util.List;

public interface DVDDao {
    boolean saveDVD(DVD dvd);
    boolean updateDVD(DVD dvd);
    boolean delDVD(int did);
    List<DVD> queryDVDs();
    List<DVD> queryDVDByName(String dname);
    List<DVD> querySortDVDByLimit(int index, int number);
    DVD queryDVDById(int did);
    List<DVD> queryDVDByStatus(int status);
}
