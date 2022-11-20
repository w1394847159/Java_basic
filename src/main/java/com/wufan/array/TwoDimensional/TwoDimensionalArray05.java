package com.wufan.array.TwoDimensional;

/**
 * 练习1
 * int arr[][]={{4,6},{1,4,5,7},{-2}};遍历该二维数组，并得到和
 */
public class TwoDimensionalArray05 {

    public static void main(String[] args) {
        int arr[][]={{4,6},{1,4,5,7},{-2}};

        for (int[] ints : arr) {

            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.println("");
        }
    }
}
