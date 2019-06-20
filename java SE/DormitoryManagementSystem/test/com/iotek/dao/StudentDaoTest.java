package com.iotek.dao;

import com.iotek.dao.impl.StudentDaoImpl;
import com.iotek.entity.Student;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class StudentDaoTest {
    private StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void findAll(){
        List<Student> list = studentDao.queryAllStudents();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void add(){
        //studentDao.addStudent(new Student("不知道","妖"));
        //studentDao.addStudent(new Student("申云帆","女"));
        studentDao.addStudent(new Student("马生缘","男"));
        studentDao.addStudent(new Student("马生缘","男"));
        studentDao.addStudent(new Student("马生缘","男"));
        findAll();
    }

    @Test
    public void del(){
        studentDao.delStudent(20190620);
        findAll();
    }

    @Test
    public void update(){
        studentDao.updateStudent(new Student(20190620,"xxx","男"));
        studentDao.updateStudentId(new Student(20190619,"马生缘","男"),2019);
        findAll();
    }

    @Test
    public void findId(){
        System.out.println(studentDao.queryStudentById(1));
    }

}
