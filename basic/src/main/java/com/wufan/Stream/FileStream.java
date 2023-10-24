package com.wufan.Stream;

import java.io.*;

/**
 * 文件输入输出流
 */
public class FileStream {
    public static void main(String[] args) {


        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //读取文件
            fileInputStream = new FileInputStream("F:\\test.txt");
            StringBuilder ss = new StringBuilder();
            fileOutputStream = new FileOutputStream(new File("F:\\test1.txt"));
            //构建O
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "GBK");

            int available = fileInputStream.available();
            //输出文件
            for (int i = 0; i < available; i++) {
               char a = (char) fileInputStream.read();
                //System.out.print((char) fileInputStream.read());
                ss.append(a);
                writer.append(a);



            }
            System.out.println(ss);
            writer.close();
            fileOutputStream.close();
            fileInputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
