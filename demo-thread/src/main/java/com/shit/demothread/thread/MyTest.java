package com.shit.demothread.thread;

import java.util.concurrent.CountDownLatch;

public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        MyService serviceTest = new MyService();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread setThread = new Thread(new MySetThread(serviceTest, countDownLatch));
        setThread.setName("set");
        Thread getThread = new Thread(new MyGetThread(serviceTest, countDownLatch));
        getThread.setName("get");
        Thread othersThread = new Thread(new MyOthersThread(serviceTest, countDownLatch));
        getThread.start();
        setThread.start();
        othersThread.start();
        countDownLatch.await();
        System.out.println("最后money：" + serviceTest.money);
        System.out.println("最后cost：" + serviceTest.cost);
        System.out.println("最后money：" + serviceTest.cost);
    }
}
