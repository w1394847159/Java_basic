package com.wufan.regular;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * ^\d 定义以数字开始
 * + 匹配一个或多个字符
 * \. 对.转义，等同于 .
 * ()? ()内数字可有可无
 */
public class RegularExpression2 {

    /**
     * Pattern.matches使用正则表达式
     */
    @Test
    public void usePattern(){
        String context = "i am noob from runoob.com";
        //正则表达式，匹配 runoob   .*匹配一个或多个任意字符
        String pattern = ".*runoob.*";

        boolean matches = Pattern.matches(pattern, context);
        System.out.println("字符串中包含 'runoob' 字符串" + matches);
    }

    /**
     * 捕获组
     */
    @Test
    public void getMatch(){
        //查找数据
        String context = "you are stupid3000 !?ok";
        String pattern = "(\\D*)(\\d+)(.*)";
        //创建Pattern对象
        Pattern compile = Pattern.compile(pattern);
        //创建matcher对象
        Matcher matcher = compile.matcher(context);
        if(matcher.find()){
            System.out.println("组1:"+matcher.group(0));
            System.out.println("组2:"+matcher.group(1));
            System.out.println("组3:"+matcher.group(2));
            System.out.println("组4:"+matcher.group(3));
        }else {
            System.out.println("NO MATCH");
        }
    }
}
