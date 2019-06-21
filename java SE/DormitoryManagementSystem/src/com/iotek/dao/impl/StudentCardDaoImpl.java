package com.iotek.dao.impl;

import com.iotek.dao.StudentCardDao;

import com.iotek.entity.Administrator;
import com.iotek.entity.StudentCard;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class StudentCardDaoImpl extends BaseDaoImpl<StudentCard> implements StudentCardDao {
    //private File studentFile = new File("file/student.dat");
    private File studentCardFile = new File("file/studentCard.dat");
    private int count = 0;

    @Override
    public boolean addStudentCard(StudentCard studentCard) {
        List<StudentCard> sList = read(studentCardFile);
        //判断该卡是否存在
        for (int i = 0; i < sList.size(); i++) {
            StudentCard s = sList.get(i);
            if (s.getStudentId()==studentCard.getStudentId()){
                return false;
            }
        }
        sList.add(studentCard);
        return write(sList,studentCardFile);
    }

    @Override
    public boolean delStudentCard(int studentId) {
        List<StudentCard> sList = read(studentCardFile);
        for (int i = 0; i < sList.size(); i++) {
            StudentCard s = sList.get(i);
            if(s.getStudentId() == studentId){
                sList.remove(i);
                return write(sList,studentCardFile);
            }
        }
        return false;
    }

    @Override
    public boolean updateStudentCard(StudentCard studentCard) {
        List<StudentCard> sList = read(studentCardFile);
        for (int i = 0; i < sList.size(); i++) {
            StudentCard s = sList.get(i);
            if(s.getStudentId() == studentCard.getStudentId()){
                sList.set(i,studentCard);
                return write(sList,studentCardFile);
            }
        }
        return false;
    }

    @Override
    public StudentCard queryStudentCardByNameAndPassword(int studentId, String pass) {
        List<StudentCard> sList = read(studentCardFile);
        for (StudentCard s : sList) {
            // 找到了用户名和密码都匹配的对象
            if(s.getStudentId()==studentId){
                if(s.getPassword().equals(pass)){
                    return s;
                }else {
                    count++;
                    if (count==3) {
                        System.err.println("密码错误"+count+"次，本次服务到此结束！");
                        System.exit(0);
                        //return null;
                    }
                    try {
                        throw new Exception("密码错误"+count+"次,请重新输入！");
                    } catch (Exception e) {
                        System.err.println("密码错误"+count+"次,请重新输入！");
                    }
                    Scanner scanner = new Scanner(System.in);
                    String p = scanner.next();
                    return queryStudentCardByNameAndPassword(studentId,p);
                }
            }
        }
        System.err.println("该用户不存在！");
        return null;
    }

    @Override
    public StudentCard queryStudentCardById(int studentId) {
        List<StudentCard> sList = read(studentCardFile);
        for (int i = 0; i < sList.size(); i++) {
            StudentCard s = sList.get(i);
            if (s.getStudentId()==studentId){
                return s;
            }
        }
        return null;
    }

    @Override
    public List<StudentCard> queryAllStudentCards() {
        return read(studentCardFile);
    }
}
