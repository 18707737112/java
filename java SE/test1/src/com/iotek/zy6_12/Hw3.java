package com.iotek.zy6_12;
/*
获取一个文件夹下所有指定后缀名(.java)的文件（包括子文件夹中的内容），
并将这些文件的绝对路径写入到一个文本文件中
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Hw3 {
    public static void main(String[] args) {
        File dir = new File("src/com/iotek/test");
        File file = new File("F:/path.txt");
        List<String> pathList = getFileBySuffix(dir,".java");
        write(pathList,file);
        System.out.println("OK");
    }
    private static void write(List<String> pathList, File file) {
        if(pathList == null || file == null || file.isDirectory()){
            throw new IllegalArgumentException("write方法参数不合法");
        }
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            for (String path : pathList) {
                pw.println(path);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            if(pw != null){
                pw.close();
            }
        }
    }
    private static List<String> getFileBySuffix(File dir, String suffix) {
        if(dir == null || dir.isFile() || !dir.exists() || suffix == null){
            throw new IllegalArgumentException("getFileBySuffix方法入参不合法");
        }
        List<String> pList = new ArrayList<>();
        File[] fs = dir.listFiles();
        for (File f : fs) {
            if(f.isFile()){
                if(f.getName().endsWith(suffix)){
                    pList.add(f.getAbsolutePath());
                }
            }else{
                pList.addAll(getFileBySuffix(f,suffix));
            }
        }
        return pList;
    }
}
