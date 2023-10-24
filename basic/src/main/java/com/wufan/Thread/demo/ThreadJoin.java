package com.wufan.Thread.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//实现线程顺序执行
//a , b ,c 三个线程顺序执行
public class ThreadJoin {
  public static   ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        //不正确
        new b().run();

        executorService.submit(new c());
    }
}



//继承Thread
class a extends Thread{
    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {
            System.out.println("我是a"+i);
        }
    }
}

//实现Runnable接口
class b implements Runnable{

    @Override
    public void run() {
        try {
            new a().start();
            new a().join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 101; i++) {
            System.out.println("我是b"+i);
        }
    }
}

//使用线程池创建线程
class c implements Callable{

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 101; i++) {
            System.out.println("我是c"+i);
        }
        return null;
    }
}
