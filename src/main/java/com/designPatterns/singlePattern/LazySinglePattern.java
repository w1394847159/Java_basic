package com.designPatterns.singlePattern;

/**
 * 单例模式-懒汉式
 * 只有在使用的时候才会加载类，添加线程安全
 */
public class LazySinglePattern {

    //私有化构造方法，类外无法创建对象
    private LazySinglePattern(){};

    //创建唯一类对象引用
    private static LazySinglePattern lazy = null;

    //创建唯一方法供外界获取实例
    public static LazySinglePattern getInstance(){
        //为确保多线程下安全，需要判断当前是否已存在此类实例
        if(lazy == null){
            synchronized (LazySinglePattern.class){
                if(lazy == null){
                    lazy = new LazySinglePattern();
                }
            }
        }

        return lazy;
    }
}
