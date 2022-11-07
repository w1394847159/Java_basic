package com.wufan.array.sort;

/**
 * 冒泡排序
 */
public class BubboSort {

    public static void main(String[] args) {

        BubboSort bubboSort = new BubboSort();
        int[] ints = {2,4,7,1,3,9,23,12,87,34,233,14};
        bubboSort.bubboSort(ints);
    }





    //冒泡排序
    public void bubboSort(int[] a){

        for (int i = 0; i < a.length-2; i++) {
            for (int i1 = 0; i1 < a.length-1; i1++) {
                int m = 0;
                if(a[i1] > a[i1+1]){
                    m = a[i1+1];
                    a[i1+1] = a[i1];
                    a[i1] = m;
                }
            }
            int t = 0;
            if(a[i] > a[i+1]){
                t = a[i+1];
                a[i+1] = a[i];
                a[i] = t;
            }
        }

        for (int i : a) {
            System.out.print(i+",");
        }

    }
}
