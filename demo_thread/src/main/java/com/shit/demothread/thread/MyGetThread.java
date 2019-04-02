package com.shit.demothread.thread;

import java.util.concurrent.CountDownLatch;

public class MyGetThread implements Runnable {
    private MyService serviceTest;
    private CountDownLatch countDownLatch;

    public MyGetThread(MyService serviceTest, CountDownLatch countDownLatch) {
        this.serviceTest = serviceTest;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            while(serviceTest.money<10){
                serviceTest.get();
            }
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
