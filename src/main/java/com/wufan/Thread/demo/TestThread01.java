package com.wufan.Thread.demo;

//创建线程方式一：  继承Thread类，重写run() 方法，调用start开启线程
public class TestThread01 extends Thread{

    //run方法线程体
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("这是子线程+"+ Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        //创建线程对象
        TestThread01 testThread1 = new TestThread01();
        testThread1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("这是主线程—+"+Thread.currentThread().getName());
        }


    }
}
