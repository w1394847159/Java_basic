package Thread.c_001;

/**
 * 开启线程和不开启线程
 */
public class Synchronized05{

    private int count = 100;

    //对此方法操作时，count-了以后，可能在输出的地方输出的是其他线程的值
    public synchronized void run1(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }


    public static void main(String[] args) {

        Synchronized05 synchronized05 = new Synchronized05();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized05.run1();
                }
            }).start();
        }
    }


}
