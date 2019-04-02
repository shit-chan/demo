package com.shit.demothread.thread;

import java.util.concurrent.CountDownLatch;

public class MyOthersThread implements Runnable {
    private MyService serviceTest;
    private CountDownLatch countDownLatch;

    public MyOthersThread(MyService serviceTest, CountDownLatch countDownLatch) {
        this.serviceTest = serviceTest;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            serviceTest.others();
            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
