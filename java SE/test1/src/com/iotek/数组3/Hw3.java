package com.iotek.数组3;

/*
* 封装一个静态方法遍历如下二维数组
*int[][] arr  = { {1,2},{3,4,5},{6,7,8,9}}
*/
public class Hw3 {
    public static void main(String[] args){
        int[][] arr  = { {1,2},{3,4,5},{6,7,8,9}};
        num(arr);
    }
    public static void num(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
