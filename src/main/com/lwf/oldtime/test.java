package com.lwf.oldtime;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class test {
    public static void main(String[] args) {
        
        AtomicInteger atomicInteger=new AtomicInteger(0);
        atomicInteger.getAndIncrement();
        AtomicReference<String> reference=new AtomicReference<>();
        AtomicStampedReference<String> reference1=new AtomicStampedReference<>("",0);
        CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();
        list.add(1);
        list.set(0,2);

        ConcurrentHashMap<Integer, Integer> integerIntegerConcurrentHashMap = new ConcurrentHashMap<>();
        integerIntegerConcurrentHashMap.put(1,1);
        ReentrantLock
                lock=new ReentrantLock();

    }
    private void test(boolean status){
        while (status!=true){
            System.out.println("条件为false,不断进行循环判断");
        }
        System.out.println("条件符合，才会走到这里");
        ReadWriteLock lock= new ReentrantReadWriteLock();

    }
    public void TestCountDownLatch() throws InterruptedException {
        CountDownLatch cdl=new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int x=i;
            new Thread(()->{
              cdl.countDown();
            },String.valueOf(x)).start();
        }
        cdl.await();

        System.out.println("只有10个线程都执行完成后，才会到这里，await会不断等待检查内部维护的count数是否到0");

    }
    public void cyclicBarrir(){
        CyclicBarrier cb=new CyclicBarrier(1,()->{
            System.out.println("cyclicBarrier 出发");
        });

    }
}
