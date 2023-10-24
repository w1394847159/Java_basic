package com.wufan.Thread.demo;

//创建线程方式2： 实现Runnable接口，重写run方法
//通过创建线程对象，将runnable接口作为构造参数传入，调用start方法
public class TestThread03 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("子线程---"+ i);
        }
    }

    public static void main(String[] args) {

        TestThread03 testThread03 = new TestThread03();
        //创建线程对象，通过线程对象开启线程
        Thread thread = new Thread(testThread03);
        thread.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("主线程---"+ i);
        }
    }
}
