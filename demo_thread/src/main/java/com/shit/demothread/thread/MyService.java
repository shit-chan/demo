package com.shit.demothread.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition conditionGet = lock.newCondition();
    public Condition conditionOthers = lock.newCondition();
    private long count = 0;
    volatile public long money = 0;
    volatile public long cost = 10;

    public void set() throws InterruptedException {
        lock.lock();
        count++;
        cost--;
        System.out.println(Thread.currentThread().getName() + count);
//        System.out.println("cost:" + cost);
        conditionGet.signal();
        conditionOthers.signal();
        lock.unlock();
        Thread.sleep(1000);
    }

    public void get() throws InterruptedException {
        lock.lock();
        if (count <= 0) {
            System.out.println(Thread.currentThread().getName() + "由于count<=0，get线程暂停");
            conditionGet.await();
        }
        count--;
        money++;
        System.out.println(Thread.currentThread().getName() + count);
//        System.out.println("money:" + money);
        lock.unlock();
    }

    public void others() throws InterruptedException {
        lock.lock();
        System.out.println("做其他事情的线程开始。。。");
        conditionOthers.await();
        System.out.println("做其他事情的线程结束。。。");
        lock.unlock();
    }
}
