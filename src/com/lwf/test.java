package com.lwf;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

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
}
