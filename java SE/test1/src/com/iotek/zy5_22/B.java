package com.iotek.zy5_22;
/*
封装一个方法，求一个行列数相同的二维数组两条对角线所有元素的和。
比如：
行列为奇数
1 2 3
4 5 6
7 8 9
求 1+5+9+3+7=25
中间的5只求一次

行列为偶数
1 2 3 4
5 6 7 8
9 0 1 2
3 4 5 6
求 1+6+1+6+4+7+0+3=28
*/
public class B {
    public static void main(String[] args) {
        System.out.println("自动生成的3行3列数组：");
        int number = sum(array(3));
        print(array(3));
        System.out.println("两条对角线所有元素的和：" + number);
        System.out.println("-----------------------");
        System.out.println("自动生成的4行4列数组：");
        int number1 = sum(array(4));
        print(array(4));
        System.out.println("两条对角线所有元素的和：" + number1);
    }
    private static int[][] array(int line){
        int[][] arr = new int[line][line];
        int num = 0;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                num ++;
                if(num == 10){
                    num = 0;
                }
                arr[i][j] = num;
            }
        }
        return arr;
    }
    private static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static int sum(int[][] arr){
        int s = 0;
        int length = arr.length;
        if(length%2 == 0){
            int num = 0;
            for (int i = 0; i < length/2; i++) {
                s += arr[i][num] + arr[i][length-1-num];
                num ++;
            }
            for (int i = length/2; i < length; i++) {
                num --;
                s += arr[i][num] + arr[i][length-1-num];
            }
        }else {
            int num = 0;
            for (int i = 0; i < length/2; i++) {
                s += arr[i][num] + arr[i][length-1-num];
                num ++;
            }
            s += arr[length/2][num];
            for (int i = length/2+1; i < length; i++) {
                num --;
                s += arr[i][num] + arr[i][length-1-num];
            }
        }
        return s;
    }
}
