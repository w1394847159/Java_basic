package com.wufan.Thread.demo;

/**
 * 模拟 多个线程同时操作一个对象
 * 此时会造成 线程不安全
 */
public class TestThread04 implements Runnable{

    //模拟抢票
    private Integer ticket = 10;

    @Override
    public void run() {
        while (true){
            //线程抢票，抢完票后票数-1


            //睡眠200ms
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //线程不安全
            //System.out.println(Thread.currentThread().getName() + "拿到了第" + ticket-- +"张票");

            //线程安全，使用synchronized 同步锁，当一个线程在操作时，另外一个线程必须等待
            synchronized (this.getClass()){
                if(ticket < 0){
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "拿到了第" + ticket-- +"张票");
            }


        }

    }

    public static void main(String[] args) {
        TestThread04 testThread04 = new TestThread04();

        new Thread(testThread04,"小猫").start();
        new Thread(testThread04,"小狗").start();
        new Thread(testThread04,"小王").start();
    }
}
