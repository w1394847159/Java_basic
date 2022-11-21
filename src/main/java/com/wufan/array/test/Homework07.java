package com.wufan.array.test;

/**
 * 写出冒泡排序代码
 */
public class Homework07 {

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
