package com.wufan.generic.customgeneric;

/**
 * 自定义泛型
 * 泛型可以指代所有的对象
 */
public class CustomGeneric {
}

//类后使用 <>扩出来，即为自定义反省类，一般使用 T
//泛型标识符可以有多个
class Tiger<T,R,M>{
    String name;
    //普通成员,属性可以使用泛型
    R r;
    M m;
    T t;
    //使用泛型的数组不可以初始化，由于

    //构造器使用泛型
    public Tiger(R r, M m, T t) {
        this.r = r;
        this.m = m;
        this.t = t;
    }



    public String getName() {
        return name;
    }

    //返回类型可以使用泛型
    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}