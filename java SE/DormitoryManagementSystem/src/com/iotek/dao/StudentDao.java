package com.iotek.dao;

import com.iotek.entity.Student;

import java.util.List;

public interface StudentDao {
    boolean addStudent(Student student);  //添加学生
    boolean delStudent(int studentId);  //删除学生
    boolean updateStudent(Student student);  //修改学生
    boolean updateStudentId(Student student,int id);//（管理员在特殊情况下）修改学生学号
    Student queryStudentById(int studentId);   //指定编号查找
    List<Student> queryAllStudents();  //读取文件（可以用来遍历学生信息）
}
