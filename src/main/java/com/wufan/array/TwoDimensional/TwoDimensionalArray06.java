package com.wufan.array.TwoDimensional;

/**
 * 练习2
 * 打印杨辉三角
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 *
 * 可以看出 a[i][j] = a[i-1][j] + a[i-1][j-1]
 */
public class TwoDimensionalArray06 {

    /**
     * 打印杨辉三角
     * 杨辉三角规律
     * @param args
     */
    public static void main(String[] args) {

        int arr[] = {1};
        int[] b = {1,1};
        int[][] ints = new int[10][];
        ints[0] = arr;
        ints[1] = b;

        for (int i = 2; i < 10; i++) {

                int[] ints1 = new int[i + 1];
                ints1[0] = 1;
                ints1[ints1.length-1] = 1;
            for (int i1 = 1; i1 < ints1.length-1; i1++) {
                ints1[i1] = ints[i-1][i1] + ints[i-1][i1-1];
            }
            ints[i] = ints1;
        }

        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+",");
            }
            System.out.println("");
        }

    }
}
