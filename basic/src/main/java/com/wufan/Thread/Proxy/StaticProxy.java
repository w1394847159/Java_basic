package com.wufan.Thread.Proxy;
/*
    静态代理

   代理与实体类实现同一个接口，通过代理获取实体类的对象

   和线程实现方式相同
 */
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        ProxyMarray proxyMarray = new ProxyMarray(you);
        proxyMarray.wedding();
    }
}

//创造一个公共接口
interface Marry{
    void wedding();
}

//建立实体类
class You implements Marry{

    @Override
    public void wedding() {
        System.out.println("我今天结婚！");
    }
}

//代理类，用于获取实体类对象
class ProxyMarray implements Marry{

    private Marry marry;
    //代理类构造参数
    public ProxyMarray(Marry marry){
        this.marry = marry;
    }



    @Override
    public void wedding() {
        before();
        //调用同一接口其它子类方法
        marry.wedding();
        after();
    }

    private void after() {
        System.out.println("欢迎下次光临");
    }

    private void before() {
        System.out.println("先给彩礼");
    }
}

