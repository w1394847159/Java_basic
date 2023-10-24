package com.wufan.array.addAndReduce;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数组动态扩容
 * 视频教程 https://www.bilibili.com/video/BV1fh411y7R8/?p=169&spm_id_from=pageDriver&vd_source=e158b5d57212e10bada6e5724e861ca2
 */
public class ArrayAdd {


    @Test
    public void person(){
        int[] a = new int[5];
        //数组动态添加，可以是创建一个新数组，将原来数组指向新数组
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            System.out.println("请输入一个整数?");
            int m = scanner.nextInt();
            if(i < a.length){
                a[i] = m;
            }

            if(i >= a.length){
                System.out.println("数组元素不足，是否扩容后添加");
                String next = scanner.next();
                if("y".equals(next)){
                    int[] ints = new int[(int) (a.length * 2)];
                    for (int i1 = 0; i1 < a.length; i1++) {
                        ints[i1] = a[i1];
                    }
                    a = ints;
                }else {
                    break;
                }
            }
        }
    }


    /**
     * 思路分析
     * 定义初始数组 int[] arr = {1,2,3}//下标0-2
     * 定义一个新的数组 int[] arrNew = new int[arr.length+1]
     * 遍历数组，依次将arr的元素拷贝到 arrNew数组
     */
    public void publicTest(){

    }

}



