package com.wufan.array.TwoDimensional;

/**
 * 创建包含不同一维数组的二维数组，并赋值
 */
public class TwoDimensionalArray02 {


    public static void main(String[] args) {
        //创建一个二维数组,此时数组中只存在了三个存放一维数组地址的空间，未创建一维数组
        int[][] arr = new int[3][];

        //创建一维数组
        for (int i = 0; i < arr.length; i++) {
            int[] ints = new int[i + 1];
            //将一维数组地址赋值给二维数组对应空间
            arr[i] = ints;

            //为一维数组赋值
            for (int i1 = 0; i1 < ints.length; i1++) {
                ints[i1] = i+1;
            }
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.println(anInt+",");
            }
        }



    }
}
