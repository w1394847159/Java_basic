package com.wufan.Thread.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/*
线程创建方式3: 实现 callable接口
 */
//1. 实现Calllable接口，需要定义返回值类型
public class TestCallable implements Callable<Boolean> {
    String url;
    String fileName;

    public TestCallable(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    //2. 重写call方法，抛出异常
    @Override
    public Boolean call() throws Exception {
        DownloadTest downloadTest = new DownloadTest();
        downloadTest.download(url,fileName);
        System.out.println("下载的文件名为："+ fileName);
        return true;
    }

    public static void main(String[] args) {

        //3. 创建目标对象
        TestCallable testCallable = new TestCallable("https://file.notion.so/f/s/feb90ca5-1f38-4dc2-bea6-ba44787f7b82/Untitled.png?id=6947ee2b-b4bb-4b8e-af93-3dbbf6cc6e22&table=block&spaceId=10676de4-4f09-4b78-b5b8-281db21cf570&expirationTimestamp=1686479219174&signature=sE94qo8h4_SDsl0P9n46y8dSMRieIY-FP_ANBCYCiX8&downloadName=Untitled.png", "D:\\Thread.png");
        TestCallable testCallable1= new TestCallable("https://file.notion.so/f/s/feb90ca5-1f38-4dc2-bea6-ba44787f7b82/Untitled.png?id=6947ee2b-b4bb-4b8e-af93-3dbbf6cc6e22&table=block&spaceId=10676de4-4f09-4b78-b5b8-281db21cf570&expirationTimestamp=1686479219174&signature=sE94qo8h4_SDsl0P9n46y8dSMRieIY-FP_ANBCYCiX8&downloadName=Untitled.png", "D:\\Thread1.png");
        TestCallable testCallable2 = new TestCallable("https://file.notion.so/f/s/feb90ca5-1f38-4dc2-bea6-ba44787f7b82/Untitled.png?id=6947ee2b-b4bb-4b8e-af93-3dbbf6cc6e22&table=block&spaceId=10676de4-4f09-4b78-b5b8-281db21cf570&expirationTimestamp=1686479219174&signature=sE94qo8h4_SDsl0P9n46y8dSMRieIY-FP_ANBCYCiX8&downloadName=Untitled.png", "D:\\Thread2.png");
        //4. 创建线程池，使用线程池提交任务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //5. 提交任务执行
        Future<Boolean> submit = executorService.submit(testCallable);
        Future<Boolean> submit1 = executorService.submit(testCallable1);
        Future<Boolean> submi2t2 = executorService.submit(testCallable2);
        //6. 获取运行结果
        try {
            Boolean aBoolean = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdownNow();
        }
    }
}


class DownloadTest{
    public void download(String url, String fileName){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
