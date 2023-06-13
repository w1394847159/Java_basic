package com.wufan.Thread.lambda;
/**
 * lambda表达式测试
 *
 * lambda表达式只有函数式接口才可以使用
 * 函数式接口 -> 一个接口里只有一个抽象方法，当创建接口实例时，可以使用lambda进行缩写
 * (方法参数) -> {方法体}
 *
 */

public class TestLambda02 {

    public static void main(String[] args) {
        //1. 正常创建对象
       hanshu ceshi = new ceshi();
       ceshi.lambda("nihao","tahao");

       //2. 使用内部类创建对象
        class ceshi1 implements hanshu{
            @Override
            public void lambda(String a, String b) {
                System.out.println("我是内部类创建的"+a +"---"+b);
            }
        }

        new ceshi1().lambda("hi","hello");

        //3. 匿名内部类创建对象
        hanshu niming = new hanshu() {
            @Override
            public void lambda(String a, String b) {
                System.out.println("我是匿名内部类创建"+a +"---"+b);
            }
        };
        niming.lambda("wo","ni");

        //简化为 lambda表达式 ()内为接口参数  -> 为指向方法实现代码
        hanshu lambda = (String a,String b) -> System.out.println("我是lambda创建"+a +"---"+b);
        lambda.lambda("la","bda");

        //再次简化 lambda表达式 可以参数类型，单个参数时可以省略 ()
        hanshu lambda2 = (a,b) ->System.out.println("我是lambda创建"+a +"---"+b);
        lambda2.lambda("aa","bda");


    }

}

class ceshi implements hanshu{
    @Override
    public void lambda(String a, String b) {
        System.out.println("我是正常创建的"+a +"---"+b);
    }
}


//创建函数式接口
interface hanshu{
    void lambda(String a,String b);
}
