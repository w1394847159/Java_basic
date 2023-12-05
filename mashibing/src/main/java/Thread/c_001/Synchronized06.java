package Thread.c_001;

import java.util.concurrent.TimeUnit;

/**
 * 模拟银行账户
 * 对业务写方法加锁
 * 对业务读方法不加锁
 */
public class Synchronized06 {
    private String name;
    private Double balance;

    //写方法加锁
    public synchronized void setBalance(String name,Double balance){
        this.name = name;

        //先设定名字，2s后设定值
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    //读方法不加锁,由于加锁方法和不加锁方法可以同时运行，当加锁方法逻辑过多或耗时较长时，不加锁方法会出现脏读
    public Double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        Synchronized06 a = new Synchronized06();
        new Thread(() -> a.setBalance("zhangsan",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

    }
}
