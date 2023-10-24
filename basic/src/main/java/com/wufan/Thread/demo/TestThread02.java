package com.wufan.Thread.demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//联系Thread,实现多线程同步下载图片
public class TestThread02 implements Runnable{

    private String url;
    private String fileName;

    public TestThread02(String url,String fileName){
        this.url = url;
        this.fileName = fileName;
    }


    public static void main(String[] args) {


        TestThread02 testThread02 = new TestThread02("https://file.notion.so/f/s/feb90ca5-1f38-4dc2-bea6-ba44787f7b82/Untitled.png?id=6947ee2b-b4bb-4b8e-af93-3dbbf6cc6e22&table=block&spaceId=10676de4-4f09-4b78-b5b8-281db21cf570&expirationTimestamp=1686479219174&signature=sE94qo8h4_SDsl0P9n46y8dSMRieIY-FP_ANBCYCiX8&downloadName=Untitled.png", "D:\\Thread.png");
        TestThread02 testThread03 = new TestThread02("https://file.notion.so/f/s/feb90ca5-1f38-4dc2-bea6-ba44787f7b82/Untitled.png?id=6947ee2b-b4bb-4b8e-af93-3dbbf6cc6e22&table=block&spaceId=10676de4-4f09-4b78-b5b8-281db21cf570&expirationTimestamp=1686479219174&signature=sE94qo8h4_SDsl0P9n46y8dSMRieIY-FP_ANBCYCiX8&downloadName=Untitled.png", "D:\\Thread2.png");
        TestThread02 testThread04= new TestThread02("https://file.notion.so/f/s/feb90ca5-1f38-4dc2-bea6-ba44787f7b82/Untitled.png?id=6947ee2b-b4bb-4b8e-af93-3dbbf6cc6e22&table=block&spaceId=10676de4-4f09-4b78-b5b8-281db21cf570&expirationTimestamp=1686479219174&signature=sE94qo8h4_SDsl0P9n46y8dSMRieIY-FP_ANBCYCiX8&downloadName=Untitled.png", "D:\\Thread1.png");

        Thread thread01 = new Thread(testThread02);
        Thread thread02 = new Thread(testThread03);
        Thread thread03 = new Thread(testThread04);


        thread01.start();
        thread02.start();
        thread03.start();

        /**
         * 输出为
         * 下载了文件名为：D:\Thread.png
         * 下载了文件名为：D:\Thread1.png
         * 下载了文件名为：D:\Thread2.png
         *
         * 多线程执行时由CPU进行调度，没有固定顺序
         */

    }


    @Override
    public void run() {
        Downloader downloader = new Downloader();
        downloader.downloader(url,fileName);
        System.out.println("下载了文件名为：" + fileName);
    }
}


//下载器
class Downloader{
    //下载图片方法,拷贝一个 网络图片到本地文件
    public void downloader(String url, String fileName){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}
