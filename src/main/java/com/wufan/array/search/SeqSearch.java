package com.wufan.array.search;

import java.util.Scanner;

/**
 * 顺序查找
 */
//todo 二分法查找未实现
public class SeqSearch {

    /**
     * 讲解视频：https://www.bilibili.com/video/BV1fh411y7R8/?p=175&spm_id_from=333.880.my_history.page.click&vd_source=e158b5d57212e10bada6e5724e861ca2
     *
     * 有一个数列：白眉鹰王、金毛狮王、紫衫龙王、青翼蝠王猜数游戏：
     * 从键盘中任意输入一个名称,判断数列中是否包含此名称【顺序查找】
     * 要求：如果找到了,就提示找到,并给出下标值
     *
     *
     * 思路分析：
     *  1, 定义字符串数组
     *  2. 接收用户输入,遍历数组,依次比较,如果有,则提示信息并退出
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] names={"白眉鹰王","金毛狮王","紫衫龙王","青翼蝠王"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要查找的名字");
        String next = scanner.next();

        //遍历数组，匹配
        for (int i = 0; i < names.length; i++) {
            if(next.equals(names[i])){
                System.out.println("在数组的第"+(i+1)+"个位置");
                break;
            }
        }
    }
}
