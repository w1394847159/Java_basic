package com.wufan.array;

import java.util.Arrays;
import java.util.Date;

public class SortTest {

    public static void main(String[] args) {
        int[] a = {4,2,23,1};
        Arrays.sort(a);
        for (int i : a) {
            System.out.println(i+",");
        }

        Date date = new Date();

        System.out.println(date.toString());
    }
}
