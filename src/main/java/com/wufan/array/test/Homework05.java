package com.wufan.array.test;

import java.util.Random;

/**
 *
 * 求最大值和最大值下标
 */
public class Homework05 {

    public static void main(String[] args) {

        //随机生存不大于100的整数
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] =(int)(Math.random() * 100);
        }
        System.out.print("原数组为：");
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println("");

        //求和
        int sum = 0;

        //存放数组最大值
        int m = a[0];
        //存放数组最大值下标
        int ss = 0;

        for (int i = 0; i < a.length; i++) {
            //当元素大于暂存值时，将暂存值更新
            if(a[i] > m){
                m = a[i];
                ss = i+1;
            }
        }


        //遍历数组，倒序打印
        for (int i = 0; i < a.length; i++) {

            //查找最大值
            if(a[i] == 8){
                System.out.println("当前数组中有8，下表为"+i);
            }
            sum += a[i];

            for (int j = 0; j < a.length-1; j++) {
                //逆序存储，冒泡排序
                if(a[j] < a[j+1]){
                    m = a[j];
                    a[j] = a[j+1];
                    a[j+1] = m;
                }

            }

        }
        System.out.print("逆序数组为：");
        for (int i : a) {
            System.out.print(i+",");
        }
        System.out.println("");
        double avg = sum/a.length;
        System.out.println("平均值为："+avg);
        System.out.println("最大值为："+a[0]+"原下标为："+ss);

    }
}
