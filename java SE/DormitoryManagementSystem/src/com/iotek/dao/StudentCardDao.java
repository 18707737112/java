package com.iotek.dao;

import com.iotek.entity.Student;
import com.iotek.entity.StudentCard;

import java.util.List;

public interface StudentCardDao {
    boolean addStudentCard(StudentCard studentCard);  //添加学生
    boolean delStudentCard(int studentId);  //删除学生卡
    boolean updateStudentCard(StudentCard studentCard);  //修改学生卡
    StudentCard queryStudentCardByNameAndPassword(int studentId,String pass);
    StudentCard queryStudentCardById(int studentId);   //指定学号查找
    List<StudentCard> queryAllStudentCards();  //读取文件（可以用来遍历学生卡信息）
}
