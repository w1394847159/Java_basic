package cn.com.wufan.basic;

import cn.com.wufan.basic.util.User;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 2. Java创建对象的几种方式
 */

public class CreateObject {


    /**
     * 1. 使用new关键字创建对象
     */
    @Test
    public void creatWithNew(){
        User user = new User();
        User nihao = new User(1, "nihao", "122348@qq.com");
        System.out.println(user);
        System.out.println(nihao);
    }


    /**
     * 2.反射创建对象   使用实体类的Class类调用newInstance创建对象
     *
     */
    @Test
    public void createWithClass(){
        try {
            User user = User.class.newInstance();
            System.out.println(user);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用构造器.newInstance方法创建对象
     * 实体类.class.getDeclareConstructors() 获取实体类中所有构造参数，按照定义先后顺序排列
     */
    @Test
    public void createWithConstructor(){

        try {
            //获取多个构造器,构造器顺序按照实体类中创建顺序排列
            Constructor<?>[] declaredConstructors = User.class.getDeclaredConstructors();
            System.out.println(declaredConstructors[0]);
            System.out.println(declaredConstructors[1]);

            //第一个是无参构造器
            Object o = declaredConstructors[0].newInstance(1,"as","ss");
            Object o1 = declaredConstructors[1].newInstance();
            System.out.println(o);
            System.out.println(o1);


        } catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 使用Clone方式创建对象
     * 使用前提： 对象实现Cloneable接口并重写clone方法
     *
     * clone出对象属性值相同，但在堆内存中地址不同
     */
    @Test
    public void createWithClone(){

        //创建已存在对象
        User user = new User(1, "nihjao ", "lihao");

        //克隆对象
        try {
            Object clone = user.clone();
            System.out.println(clone);
            System.out.println(user == clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }


    /**
     * 使用反序列化方法创建对象
     * 通用于网络中传输对象
     * 序列化之前对象和反序列化对象在堆内存中并不是同一个
     */
    @Test
    public void createWithSerializable(){
        //创建已存在对象
        User user = new User(1, "nihjao ", "lihao");

        //使用序列化工具先对对象进行序列化，序列化为字节
        byte[] serialize = SerializationUtils.serialize(user);

        //再使用反序列化工具对对象进行序列化
        User deserialize =(User)SerializationUtils.deserialize(serialize);
        System.out.println(deserialize);

        //对比序列化和反序列化后对象是否一致
        System.out.println(user == deserialize);

    }

}
