package com.wufan.Thread.lambda;

public class TestLambda {

    public static void main(String[] args) {

        //匿名内部类
        ILike iLike = new ILike() {
            @Override
            public void lambda(String a) {
                System.out.println("我是lambda");
            }
        };

        iLike.lambda("测试");

        //lambda表达式 简化 () 里可以传入参数
        iLike = (a) -> System.out.println("给我一下" + a);
        iLike.lambda("ces");

    }
}


//定义函数式接口
interface ILike{
    void lambda(String a);
}


class Like implements ILike{

    @Override
    public void lambda(String a) {
        System.out.println(" I like lambda");
    }
}
