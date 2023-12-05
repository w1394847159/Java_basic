package Thread.c_001;

/**
 * 加锁方式2
 直接对方法使用synchronized关键字，当调用此方法时，默认使用锁机制
 静态方法使用锁时默认锁定当前类对象
 */
public class Synchronized04 {
    private static int count = 10;
    public synchronized static void m() {  //静态方法使用锁时等同于 synchronized(Synchronized04.class)
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }




    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    m();
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    m();
                }
            }
        });

        thread.start();
        thread1.start();



    }
}
