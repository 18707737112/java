package com.iotek.Java后缀;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取一个文件夹下所有指定后缀名(.java)的文件（包括子文件夹中的内容），
 * 并将这些文件的绝对路径写入到一个文本文件中
 * 思路一：
 * 1.先统计出所有的路径
 * 2.一口气全部写入文件
 * 思路二：
 * 一边统计一边写入文件（追加模式）
 */
public class Hw1Demo {
    public static void main(String[] args) {
        File dir = new File("src/com/iotek/test"); // 要搜索的文件夹
        File file = new File("F:/path.txt"); // 保存文件路径

        // 搜索目标文件，并存入集合
        List<String> pathList = getFileBySuffix(dir,".java");
        // 将集合写入文件
        write(pathList,file);
        System.out.println("OK");
    }

    // 将集合中的绝对路径写入文件
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
            if(f.isFile()){ // 是文件
                if(f.getName().endsWith(suffix)){ // 是以指定后缀结尾
                    pList.add(f.getAbsolutePath()); // 将其绝对路径保存到集合中
                }
            }else{// 是目录（如果说一个File对象不是文件，就一定是目录吗？
                            // 非也，如果File对象表示的文件不存在，则既不是文件，也不是目录）
                pList.addAll(getFileBySuffix(f,suffix));
                // 如果不想传入list作为参数，则需要将下一层递归方法的返回数据加进来addAll
            }
        }
        return pList;
    }
}
