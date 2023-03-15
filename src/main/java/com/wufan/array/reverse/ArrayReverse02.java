package com.wufan.array.reverse;

/**
 * 使用自身数组反转来完成逆序
 * 一个六位的数组，将第一位与第六位数据交换，第二位与第五位数据交换，第三位与第四位数据交换，总共交换三次
 *  实际的计算次数为 arr.length / 2
 *
 */
public class ArrayReverse02 {

    public static void main(String[] args) {
        //定义一个中间变量用来存储交换数据的值
        int[] a = {1,2,3,4,5,6,7};
        int m = 0;
        for (int i = 0; i < a.length / 2; i++) {
            m = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = m;
        }

        for (int i : a) {
            System.out.println(i+",");
        }
    }
}
