package com.wufan.Stream;

import org.junit.Test;

import java.io.*;

/**
 * 字节流字符流操作
 */
public class JavaStream {

    public static void main(String[] args) {
        JavaStream javaStream = new JavaStream();
        //javaStream.test1();
        //System.out.println();
        javaStream.write();

    }

    @Test
    public void test1(){
        //获取一个绑定控制台的字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bufferedReader.readLine();
            System.out.println("我输入的字符串为："+s);
            FileInputStream fileInputStream = new FileInputStream("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用write控制台输出
     */
    @Test
    public void writeDemo(){
        int b;
        b = 'a';
        System.out.write(b);
        System.out.write('\n');
    }

    @Test
    public  void write(){
        //读取文件
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream("D:\\dd.txt"));
            //写数据流
            dataOutputStream = new DataOutputStream(new FileOutputStream("D:\\dd.txt"));
            //使用字符流读取
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));

            String count;
            //读取每一行数据
            while ((count = bufferedReader.readLine()) != null){
                String u = count.toUpperCase();
                System.out.println(u);
                dataOutputStream.writeBytes(u+"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(dataInputStream != null){
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(dataOutputStream != null){
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
