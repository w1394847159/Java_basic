package cn.com.wufan.basic.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * 实现 Serialzable,Cloneable
 */
public class User implements Cloneable, Serializable {

    //参数
    private int id;
    private String name;
    private String email;


    //有参public修饰构造函数
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    //无参构造函数
    public User() {
    }

    //重写equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }


    //重写hashCode方法
    @Override
    public int hashCode(){
        return Objects.hash(id,name,email);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {



        return (User)super.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
