package com.iotek.Java后缀;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Hw1Demo2 {
    public static void main(String[] args) {
        File dir = new File("src/com/iotek/test"); // 要搜索的文件夹
        File file = new File("F:/path2.txt"); // 保存文件路径
        write(dir,".java",file);
        System.out.println("SUCCESS!");
    }

    private static void write(File dir, String suffix, File file) {
        // 入参检查
        if(dir == null || suffix == null || file == null || !dir.exists() || dir.isFile() || file.isDirectory()){
            throw new IllegalArgumentException("write方法入参不合法");
        }
        File[] fs = dir.listFiles();
        if(fs != null){
            for (File f : fs) {
                if(f.isFile()){
                    if(f.getName().endsWith(suffix)){
                        // 以追加模式写入文件
                        write0(f.getAbsolutePath(),file);
                    }
                }else{
                    write(f,suffix,file);
                }
            }
        }
    }

    // 该方法为内部帮助方法
    private static void write0(String path, File file) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file,true); // 追加模式
            bw = new BufferedWriter(fw);
            bw.write(path);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
