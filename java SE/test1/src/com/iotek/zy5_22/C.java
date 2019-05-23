package com.iotek.zy5_22;
/*
有一个已经排好序的数组
{1,3,10,23,25,33,41}。
现输入一个数，
要求按原来的规律将它插入数组中。
要求：
插入数组要用方法完成。
当插入的元素大于最大的数则不插入。
例如
插入8
输出数组顺序为：
1,3,8,10,23,25,33,41
*/
public class C {
    public static void main(String[] args) {
        int[] arr = {1,3,10,23,25,33,41};
        int[] brr = array(arr,8);
        if (brr == null){
            System.out.println("插入的元素大于最大的数不插入！");
            return;
        }
        System.out.println("原数组");
        print(arr);
        System.out.println("新数组");
        print(brr);
    }
    private static int[] array(int[] arr,int num){
        if(num >arr[arr.length-1]){
            return null;
        }
        int[] brr = new int[arr.length+1];
        brr[0] = num;
        for (int i = 0; i < brr.length-1; i++) {
            brr[i+1] = arr[i];
        }
        int t = 0;
        for (int i = 0; i < brr.length; i++) {
            for (int j = 0; j < brr.length-i-1; j++) {
                if(brr[j]>brr[j+1]){
                    t = brr[j];
                    brr[j] = brr[j+1];
                    brr[j+1] = t;
                }
            }

        }
        return brr;
    }
    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
