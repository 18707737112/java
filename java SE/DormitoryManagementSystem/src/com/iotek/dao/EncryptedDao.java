package com.iotek.dao;

import com.iotek.entity.Encrypted;

import java.util.List;

public interface EncryptedDao {
    boolean addEncrypted(Encrypted encrypted);  //添加密保
    boolean delEncrypted(int studentId);  //删除一个人的密保
    boolean updateEncryptedCard(Encrypted studentCard);  //修改密保
    List<Encrypted> queryEncryptedById(int studentId);   //指定学号查找一个人的密保（可以随机抽取一个密保）
    List<Encrypted> queryAllEncrypteds();  //读取文件（可以用来遍历密保信息）

}
