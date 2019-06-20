package hw4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 在文本文件中存有斐波那契数列，1,1,2,3,5,8,13,21,34,55…读取第12个数
 * 思路：
 * 1.通过递归方法产生斐波那契数列的前20项，并存入集合中
 * 2.通过方法将数据写入文件
 * 3.通过方法将文件中的数据读出来
 * 4.解析读出来的数据，并返回第n项
 */
public class Hw2Demo {
    public static void main(String[] args) {
        // 1.
        List<Integer> list = genFibo(40);

        // 2.
        File file = new File("fibonacci.txt");
        writeFile(list,file);

        // 3.4.
        int n = 20;
        int num = readFile(file,n);
        System.out.println("第"+n+"项是："+num);
    }

    // 读取指定file，并获取该文件中数据的第n项
    private static int readFile(File file, int n) {
        if(file == null || file.isDirectory() || n <= 0){
            return -1;
        }
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = br.readLine();
            String[] ss = line.split(",");
            return Integer.parseInt(ss[n-1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    // 将list中的数据写入指定的file文件
    private static void writeFile(List<Integer> list, File file) {
        if(list == null || file == null || list.size() == 0 || file.isDirectory()){
            System.err.println("writeFile的入参不合法！");
            return ;
        }
        try {
            PrintWriter pw = new PrintWriter(file);
            for (Integer num : list) {
                pw.print(num+",");
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (Integer num : list) {
                bw.write(num+",");
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static List<Integer> genFibo(int n) {
        if(n <= 0){
            throw new IllegalArgumentException("数列个数为负数！");
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= n; i ++){
            list.add(fib(i));
        }
        return list;
    }

    // 返回斐波那契数列中的第n个数
    private static int fib(int n){
        if(n < 0){
            throw new IllegalArgumentException("n为负数！");
        }

        if(n == 1 || n == 2){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }
}
