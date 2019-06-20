package com.iotek.zy6_06;

import java.io.File;
import java.io.IOException;

/*
判断一个文件是否存在，不存在则创建，
并且权限为全都可以读写执行，
如果已存在则把权限改为读写执行
*/
public class Hw3 {
    public static void main(String[] args) {
        File file = new File("F:/java/a.txt");
        try {
            if(file.createNewFile()){
                System.out.println("对象不存在，创建新对象成功---");
                file.setExecutable(true);
                file.setReadable(true);
                file.setWritable(true);
                System.out.println("权限改为读写执行成功！");
            }else {
                System.out.println("对象存在---");
                file.setExecutable(true);
                file.setReadable(true);
                file.setWritable(true);
                System.out.println("权限改为读写执行成功！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
