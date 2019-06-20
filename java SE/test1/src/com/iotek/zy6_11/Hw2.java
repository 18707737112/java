package com.iotek.zy6_11;

import java.io.File;

/*
使用file类delete方法和递归算法删除一个文件夹
注意：要求被删除的文件夹中存有子文件夹，子文件夹中还存储着各种文件和文件夹
*/
public class Hw2 {
    public static void main(String[] args) {
        File file = new File("F:/bbs");
        deleteDir(file);
    }
    public static void deleteDir(File dir){
        // 入参检查
        if(dir == null || !dir.exists()){
            System.err.println("目标文件夹不存在");
            return ;
        }

        File[] fs = dir.listFiles();
        for(File f : fs){
            if(f.isFile()){ // 文件
                f.delete();
                System.out.println("--删除文件成功！");
            }else if(f.isDirectory() && f.list().length==0){ // 空文件夹
                System.out.println("==删除文件夹成功！");
                f.delete();
            }else{ // 非空文件夹
                deleteDir(f); // 递归
            }
        }

        dir.delete(); // dir文件夹中的文件都删除后，它就变成了空文件夹了，此时可以删除它了
    }
}
