package com.wufan;

import java.io.File;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {


        ArrayList<String> dire = new ArrayList<>();

        dire.add("spring");
        dire.add("dubbo");
        dire.add("FfastdfS");
        dire.add("html");
        dire.add("java");
        dire.add("jvm");
        dire.add("Netty");
        dire.add("Nginx");
        dire.add("pageHelper");
        dire.add("redis");
        dire.add("Tengine");
        dire.add("RestFul");
        dire.add("zookeeper");
        dire.add("多线程");
        dire.add("分页");
        dire.add("高并发");
        dire.add("mysql");
        dire.add("开发");
        dire.add("亿级流量");
        dire.add("ActiveMQ");
        dire.add("区块链");

        File file = new File("F:\\Class\\马士兵\\马士兵java高级互联网架构师");
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                if(file1.isFile()){
                    //按空格切分第一个数字
                    String name = file1.getName();
                    String[] s = name.split(" ");
                    if(s.length > 2){
                        String pre = s[1];
                        
                    }
                }
            }
        }
    }
}
