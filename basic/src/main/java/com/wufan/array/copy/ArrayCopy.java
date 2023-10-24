package com.wufan.array.copy;

import java.util.Arrays;

public class ArrayCopy {

    public static void main(String[] args) {
        int arr[] = {10,20,30};
        int[] ints = Arrays.copyOf(arr, 3);


        int[] ints1 = new int[3];

        for (int i = 0; i < ints.length; i++) {
            ints1[i] =ints[ints.length-i-1];
            System.out.print(ints1[i] + ",");
        }


    }

}
