package com.wufan.array.test;

import org.junit.Test;

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

    //老师讲解

    @Test
    public void homework(){
        //创建数组
        int[] arr = {10,20,45,90};
        int insertNum = 23;
        //插入位置索引
        int index = -1;

        //将arr元素拷贝到 arrNew,并跳过index位置
        //分析
        for (int i = 0; i < arr.length; i++) {
            //找到要插入的位置
            if(insertNum > arr[i]){
                //如果 插入元素比升序数组中某一元素大时，其 i+1位置即为插入元素位置，例如 23,比20大，插入位置即为 i+1 2
                index = i+1;
            }//如果遍历完后，没有满足条件，说明此元素处于 index = 0;

            if(index == -1){
                index = 0;
            }
        }

        int[] arrNew = new int[arr.length + 1];
        //遍历新数组，当i不和索引位置相同时，插入元素
        /**
         * 此题中，
         *  1. i=0 != 2,将 10拷贝给arrNew[0]
         *  2. i=1 != 2,将20拷贝给arrNew[1]
         *  3. i=2 == 2,将23赋值给 arrNew[2]
         *  4. i=3 ！=2 ,将45拷贝给 arrNew[3]
         *  5. i=4 != 2,将90拷贝给 arrNew[4]
         */
        for (int i = 0,j=0;i < arrNew.length; i++) {
            if(i != index){
                //可以将arr元素拷贝到arrNew
                arrNew[i] = arr[j];
                //为原数组arr元素的位置
                j++;
            }else {
                //数组下标为arrNew需要插入元素位置
                arrNew[i] = insertNum;
            }
        }

        arr = arrNew;

        for (int i : arr) {
            System.out.print(i+",");
        }

    }


    //老师讲解后自我实现
    @Test
    public void test3(){

        //创建数组
        int[] arr = {10,20,45,90};
        //需要插入的数据
        int insertNum = 28;
        //需要插入的下标
        int index = -1;

        //获取到要插入数据的下标
        for (int i = 0; i < arr.length; i++) {
            //当插入元素《数组元素时，此数组元素的下标即为插入元素下表，数组元素顺序后延
            //例如 i=26 < 45,则插入下标为 2(从0计算),45，90顺序后延
            if(insertNum > arr[i]){
                index = i+1;
            }
        }
        //当index=-1，即当前数组没有大于插入元素的值，插入元素默认位置为最后下标+1
        if(index == -1){
            index = 0;
        }

        //创建新数组，存储原数组元素
        //其余位置都按顺序插入
        int[] arrNew = new int[arr.length + 1];
        //i为新数组下标，j为原数组下标，原数组数据个数不变，按照顺序导入新数组，中间插入需要插入的元素
        for (int i = 0,j=0; i <arrNew.length ; i++) {
            //当index=i时，此位置为插入的元素位置
            if(index == i){
                arrNew[i] = insertNum;
            }else {
                arrNew[i] = arr[j];
                //旧数组每一个元素都导入新数组中，除了插入的元素位置，其余元素位置不变
                j++;
            }

        }

        //释放原数组
        arr = arrNew;

        for (int i : arr) {
            System.out.printf(i+",");
        }

    }




    /**
     * 思路：本质为数组扩容+定位
     * 1. 先确定 添加数应该插入到哪个索引
     * 2. index 插入位置
     */
    @Test
    public void test(){
        //创建数组
        int[] arr = {10,20,45,90};
        int insertNum = 99;
        //插入位置索引
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            //找到要插入的位置
            if(insertNum > arr[i]){
                //如果 插入元素比升序数组中某一元素大时，其 i+1位置即为插入元素位置，例如 23,比20大，插入位置即为 i+1 2
                index = i+1;
            }//如果遍历完后，没有满足条件，说明此元素处于 index = 0;
            else {
                index = 0;
            }
        }
        //创建新数组存放原有数组元素
        int[] b = new int[arr.length + 1];

        for (int i = 0; i < b.length-1; i++) {
            b[i] = arr[i];
        }
        for (int i = b.length-1; i > index; i--) {
            //从index位置起对数据元素进行遍历
            int m = 0;
            b[i] = b[i-1];
        }
        b[index] = insertNum;

        for (int i : b) {
            System.out.print(i+",");
        }

    }



    //个人实现
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
