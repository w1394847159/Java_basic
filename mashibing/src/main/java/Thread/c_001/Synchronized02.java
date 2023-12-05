package Thread.c_001;

/**
 * 加锁方式2
 直接对方法使用synchronized关键字，当调用此方法时，默认使用锁机制
 */
public class Synchronized02 {
    private int count = 10;
    public synchronized void m() {
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }

}
