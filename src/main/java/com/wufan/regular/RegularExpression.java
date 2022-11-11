package com.wufan.regular;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * 正则表达式
 *
 */
public class RegularExpression {


    /**
     * java.util.regex 使用
     * Pattern类，用于对正则表达式进行编译
     * Mattern类：Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
     *
     */
    @Test
    public void RegexExample1(){
        String content = "dshajewq dhasfuy dsaoi dummob dsallwqe";
        String pattern = ".*dummob.*";
        boolean matches = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了字符串"+matches);
    }

}
