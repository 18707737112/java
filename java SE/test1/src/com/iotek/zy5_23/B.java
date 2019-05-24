package com.iotek.zy5_23;

/*
给定一个字符串数组，按照字典顺序进行从小到大的排序
（排序算法自己写，不允许用Arrays.sort()）
{ "asda", "ret", "vsa", "asdf", "vdft", "qwr" }
*/
public class B {
    public static void main(String[] args) {
        String[] arr = { "asda", "ret", "vsa", "asdf", "vdft", "qwr" };
        System.out.println("排序前：");
        print(arr);

        String[] brr = array(arr);
        System.out.println("升序排序后：");
        print(brr);
    }
    private static String[] array(String[] arr){
        String t = null;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0){
                    t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        return arr;
    }
    private static void print(String[] arr){
        for(String s : arr){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
