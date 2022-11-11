package com.wufan.array.TwoDimensional;

/**
 * 视频链接：https://www.bilibili.com/video/BV1fh411y7R8/?p=176&spm_id_from=pageDriver&vd_source=e158b5d57212e10bada6e5724e861ca2
 *
 * 请用二维数组输出如下图形
 * 000000
 * 001000
 * 020300
 * 000000
 */
public class TwoDimensionalArray01 {
    public static void main(String[] args) {

        //创建二维数组
        int[] [] arr = {{0,0,0,0,0,0},{0,0,1,0,0,0},{0,2,0,3,0,0},{0,0,0,0,0,0}};

        //输出二维图形
        for (int i = 0; i < arr.length; i++) { //遍历二维数组的每一个元素
            //遍历二维数组的每个元素（数组）
            //arr[i].length 二维数组中一维数组的长度
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
