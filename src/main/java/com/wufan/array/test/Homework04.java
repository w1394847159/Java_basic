package com.wufan.array.test;

import java.util.Scanner;

/**
 * 4.已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序，比如
 * [10,12,45,90],添加23后，数组为[10,12,23,45,90]
 *
 * 考察数组插入元素排序
 * 思路：
 *  输入一个元素存入数组，对数组元素进行冒牌排序
 */
public class Homework04 {

    public static void main(String[] args) {
        //创建数组
        int[] a = new int[10];

        for (int i = 0; i < a.length; i++) {
            //存入元素
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入元素：");
            int num = scanner.nextInt();
            a[i] = num;

            for (int j = 0; j < a.length-1; j++) {
                int m = 0;
                if(a[j] > a[j+1]){
                    m  = a[j+1];
                    a[j+1] = a[j];
                    a[j] = m;
                }

            }
            System.out.print("当前数组为：");
            for (int i1 : a) {
                System.out.print(i1+",");
            }
            System.out.println("");


        }



    }
}
