package com.wufan.Thread.demo;

/**
 * 模拟龟兔赛跑，让乌龟赢
 */
public class Race implements Runnable{


    //胜利者
    private static String winner;

    //总距离
    private Integer end = 1000;

    //设计步伐，兔子一秒钟跑5m,乌龟1s跑2m

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }


    /**
     * 兔子跑到最后10m的时候开始睡觉，乌龟不休息
     */
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if("兔子".equals(Thread.currentThread().getName())){
                if(winner != null){
                    break;
                }
                //兔子每s跑 5m，但是最后10m睡觉
                System.out.println("兔子跑了--"+ i*5 +"米");
                if(1000 - i*5 == 10){
                    try {
                        System.out.println("兔子在最后10m睡觉了");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {


                    }
                }
                if(1000 - i*5 < 0){
                    System.out.println("比赛结束");
                    winner = Thread.currentThread().getName();
                    break;
                }
            }

            if("乌龟".equals(Thread.currentThread().getName())){
                //兔子每s跑 5m，但是最后10m睡觉
                System.out.println("乌龟跑了--"+ i*2 +"米");
                if(1000 - i*5 < 0){
                    System.out.println("比赛结束");
                    winner = Thread.currentThread().getName();
                    break;
                }
            }


        }


        setWinner();

    }

    public void setWinner(){
        System.out.println("胜利者是 "+winner);
    }
}
