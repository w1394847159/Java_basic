package com.wufan.array.test;

import org.junit.Test;

/**
 * 写出冒泡排序代码
 */
public class Homework07 {

    //老师实现 从小到大
    @Test
    public void test1(){
        int[] aa = new int[10];
        for (int i = 0; i < aa.length; i++) {
            aa[i] = (int) (Math.random() * 100);
        }
        System.out.println("当前数组为：");
        for (int i = 0; i < aa.length; i++) {
            System.out.print(aa[i] + "\t");
        }
        System.out.println("");

        //定义辅助遍历
        int temp = 0;
        //从小到大排序
        for (int i = 0; i < aa.length-1; i++) { //外层循环，即需要比较几轮
            for (int j = 0; j < aa.length - 1 - i; j++) { //每一轮需要比较的次数，即一个数需要和几个数比较,此处-i主要是减少循环的次数
                if(aa[j] > aa[j+1]){
                    temp = aa[j];
                    aa[j] = aa[j+1];
                    aa[j+1] = temp;
                }

            }

        }
        System.out.println("从小到大排序后的数组--------------------");
        for (int i = 0; i < aa.length; i++) {
            System.out.printf(aa[i] + "\t");
        }


        //--------------------从大到小-----------------------
        //从小到大排序
        for (int i = 0; i < aa.length-1; i++) { //外层循环，即需要比较几轮
            for (int j = 0; j < aa.length - 1 - i; j++) { //每一轮需要比较的次数，即一个数需要和几个数比较,此处-i主要是减少循环的次数
                if(aa[j] < aa[j+1]){
                    temp = aa[j];
                    aa[j] = aa[j+1];
                    aa[j+1] = temp;
                }

            }

        }
        System.out.println("");
        System.out.println("从大到小排序后的数组--------------------");
        for (int i = 0; i < aa.length; i++) {
            System.out.printf(aa[i] + "\t");
        }


    }






    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 100);
        }
        sort(ints);

        for (int anInt : ints) {
            System.out.printf(anInt+",");
        }


    }

    /**
     * 冒泡排序
     * @param a 排序前数组
     * @return
     */
    public static void sort(int[] a){

        int m = 0;
        //将进行n-2轮排序
        for (int i = 0; i < a.length-2; i++) {
            //第一轮排序
            for (int j = 0; j < a.length-1; j++) {
                //当前一个元素>后一个元素时，更换位置
                if(a[j] > a[j+1]){
                    m = a[j+1];
                    a[j+1] = a[j];
                    a[j] = m;
                }
            }
        }

    }

}
