package Thread.c_001;

import java.util.concurrent.TimeUnit;

/**
 * 异常锁概念
 * 程序中出现异常，锁将被释放
 *
 * 下面代码当count = 5时，程序报异常，此时t1线程结束，而t2线程从6开始继续对count累加
 */
public class Synchronized07 {
    int count = 0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName() + " start");
        while (true){
            count ++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if(count == 5){
                int i = 1/ 0;  //此处出现异常
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Synchronized07 synchronized07 = new Synchronized07();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized07.m();
            }
        };

        new Thread(runnable,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(runnable,"t2").start();

    }


}
