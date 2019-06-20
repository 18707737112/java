package hw4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        File file = new File("F:/a.txt");
        List<Character> list = readFile(file);
        List<Character> newList = english(list);
        File newfile = new File("F:/a.txt");
        writeFile(list,newfile);
    }

    //大小写互换
    public static List<Character> english(List<Character> list){
        int lenght = list.size();
        int n = 'a'- 'A';
        for (int i = 0; i < lenght; i++) {
            if (list.get(i)>'a'&&list.get(i)<'z'){
                char x = (char) (list.get(i)-n);
                list.set(i,x) ;
                System.out.println(x);
            }
            if (list.get(i)>'A'&&list.get(i)<'Z'){
                char x = (char) (list.get(i)+n);
                list.set(i,x);
                System.out.println(x);
            }
        }

        return list;
    }

    //读取文件并存入List集合
    public static List<Character> readFile(File file){
        List<Character> list = new ArrayList<Character>();
        if(file == null || file.isDirectory()){
            try {
                throw new Exception("参数不合法！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int data = 0;
            while((data = fr.read()) != -1){
                list.add((char) data);
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    //重新写入文件
    public static void writeFile(List<Character> list, File file) {
        if(list == null || file == null || list.size() == 0 || file.isDirectory()){
            System.err.println("writeFile的入参不合法！");
            return ;
        }
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (char c : list) {
                bw.write(c);
            }
            System.out.println("完成！");
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
}
