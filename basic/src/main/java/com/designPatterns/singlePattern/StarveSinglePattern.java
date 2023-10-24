package com.designPatterns.singlePattern;

/**
 * 饿汉式，在类加载的时候已经创建了唯一的实例
 * 不存在线程安全问题
 */
public class StarveSinglePattern {

    //私有化构造方法
    private StarveSinglePattern(){};

    //创建唯一的实例
    private static final StarveSinglePattern starve = new StarveSinglePattern();

    //提供唯一的开放方法获取实例
    public static StarveSinglePattern getInstance(){
        return starve;
    }

}
