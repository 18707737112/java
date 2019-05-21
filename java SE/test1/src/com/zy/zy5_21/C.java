package com.zy.zy5_21;

//给定一组排序整数，
// 二分查找一个键值，
// 找到的返回其索引
public class C {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int key = 5;
        is_key(arr,key);
    }
    private static int numKey(int[] arr,int key){
        int low = 0;
        int high = arr.length -1;
        int i;
        while(low <= high){
            i = (low + high)/2;
            if(arr[i] == key){
                return i;
            }
            if(arr[i] > key){
                high = i - 1;
            }else{
                low = i + 1;
            }
        }
        return -1;
    }
    private static void is_key(int[] arr,int k){
        int key = numKey(arr,k);
        if (key == -1){
            System.out.println("该值不存在！");
        }else{
            System.out.println("该键值所在下标："+key);
        }
    }
}
