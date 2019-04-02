package com.shit.demothread.thread;

import java.util.concurrent.CountDownLatch;

public class MySetThread implements Runnable {
    private MyService serviceTest;
    private CountDownLatch countDownLatch;

    public MySetThread(MyService serviceTest, CountDownLatch countDownLatch) {
        this.serviceTest = serviceTest;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            while(serviceTest.cost>0){
                serviceTest.set();
            }
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
