package com.iotek.zy6_11;

import java.io.*;

/*
复制一个MP3文件
要求：将D盘根目录下的src.mp3文件复制到同一目录下并命名为des.mp3
*/
public class Hw1 {
    public static void main(String[] args) {
        File scr = new File("E:/QQ Downloads/技术强化文档.docx");
        File des = new File("F:/java/des.docx");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(scr);
            fos = new FileOutputStream(des);
            byte[] buff = new byte[100*1024];
            int lenght = 0;
            while ((lenght = fis.read(buff))!=-1){
                fos.write(buff,0,lenght);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
                System.out.println("拷贝完成！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
