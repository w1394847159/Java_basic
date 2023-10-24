package com.wufan.array.reverse;

/**
 * 使用一个新数组，用于存储旧数组的值
 */
public class ArrayReverse01 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[] b = new int[7];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length-1-i];
        }
    }
}
