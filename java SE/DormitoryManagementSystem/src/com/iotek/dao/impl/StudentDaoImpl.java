package com.iotek.dao.impl;

import com.iotek.dao.StudentDao;
import com.iotek.entity.Student;

import java.io.File;

import java.util.List;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
    private File studentFile = new File("file/student.dat");

    @Override
    public boolean addStudent(Student student) {
        List<Student> sList = read(studentFile);

        if(sList.size() == 0){
            student.setStudentId(1);
        }else{
            int newId = sList.get(sList.size()-1).getStudentId()+1;
            student.setStudentId(newId);
        }
        sList.add(student);

        return write(sList,studentFile);
    }

    @Override
    public boolean delStudent(int studentId) {
        List<Student> sList = read(studentFile);
        for (int i = 0; i < sList.size(); i++) {
            Student s = sList.get(i);
            if(s.getStudentId() == studentId){
                sList.remove(i);
                return write(sList,studentFile);
            }
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        List<Student> sList = read(studentFile);
        for (int i = 0; i < sList.size(); i++) {
            Student s = sList.get(i);
            if(s.getStudentId() == student.getStudentId()){
                sList.set(i,student);
                return write(sList,studentFile);
            }
        }
        return false;
    }

    @Override
    public boolean updateStudentId(Student student,int id) {
        List<Student> sList = read(studentFile);
        for (int i = 0; i < sList.size(); i++) {
            Student s = sList.get(i);
            if(s.getStudentId() == student.getStudentId()){
                student.setStudentId(id);
                sList.set(i,student);
                return write(sList,studentFile);
            }
        }
        return false;
    }

    @Override
    public Student queryStudentById(int studentId) {
        List<Student> sList = read(studentFile);
        for (int i = 0; i < sList.size(); i++) {
            Student s = sList.get(i);
            if (s.getStudentId()==studentId){
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> queryAllStudents() {
        return read(studentFile);
    }
}
