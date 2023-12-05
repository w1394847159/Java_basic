package Thread.c_001;

/**
 * synchronized锁机制
 * 获取的锁不一定是操作的值，而是对某个对象进行加锁，所有线程去获取此对象的锁
 *
 */
public class Synchronized03 {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized (this) {//直接使用this也可以获取到当前锁
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }
}
