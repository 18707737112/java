package com.zy.zy5_21;

import java.util.Random;

//随机产生40个10到50的整数，
// 统计每个数字各出现几次，
// 出现0次的数字不打印
public class B {
    public static void main(String[] args) {
        count(arr());
    }

    private static int[] arr(){
        Random random = new Random();
        int[] brr = new int[40];
        for (int i = 0; i < 40; i++) {
            brr[i] = random.nextInt(41)+10;
            System.out.print(brr[i] + " ");
        }
        System.out.println();
        return brr;
    }

    private static void count(int[] arr){
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    num++;
                }
            }
            if (num!=0){
                System.out.println(arr[i] + "出现的次数：" + num);
                num = 0;
            }
        }
    }

}
