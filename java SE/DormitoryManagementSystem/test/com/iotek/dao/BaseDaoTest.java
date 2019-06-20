package com.iotek.dao;

import com.iotek.dao.impl.BaseDaoImpl;
import com.iotek.entity.Student;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//文件读写基地
public class BaseDaoTest<T> {
    private File file = new File("file/baseDaoTest.dat");
    private BaseDaoImpl baseDao = new BaseDaoImpl();

    @Test
    public void testWrite(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1352100118,"马生缘","男"));
        list.add(new Student(1352100119,"申云帆","女"));
        list.add(new Student(1352100120,"不知道","妖"));
        baseDao.write(list,file);
    }

    @Test
    public void testRead(){
        List<Student> sList = baseDao.read(file);
        for (Student student : sList) {
            System.out.println(student);
        }
    }
}
