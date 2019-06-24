package com.iotek.biz;

import com.iotek.entity.*;

public interface AdministratorBiz {
    boolean register(Administrator administrator); // 注册(测试类注册)
    Administrator login(Administrator administrator); //1.登录
    boolean addStudent(Student student);//添加学生信息
    void lookAllStudents();//查询学生信息
    void updateStudent(Student student);//查询学生信息
    void lookAllBed();//查询学生宿舍
    //void updateBed(Bed bed);//调换学生宿舍
    void updateStudentId(Student student,int id);//修改学号
    void findCheck();//查询迁入迁出记录
    boolean addCheck(int studentId);//迁入
    boolean updateCheck(Check check);//迁出
    boolean addDormitory(Dormitory dormitory);//添加宿舍楼
    boolean updateDormitory(Dormitory dormitory);//修改
    boolean addRoom(Room room);//添加宿舍
    boolean updateRoom(Room room);//修改
    boolean addB(Bed bed);//新建床位
    boolean updateB(Bed bed);//修改床位
    void findNullBed(Dormitory dormitory);//查看宿舍楼每个宿舍空床数量
    void findNullBedArray(Room room);
    boolean addBed(Bed bed,String sex);//新人入住
    boolean updateBed(Bed bed,String sex);//修改(调换学生宿舍)
}
