package com.lwf;

import org.springframework.aop.aspectj.TypePatternClassFilter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    volatile int num=1;
    volatile boolean iszero=true;


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            while(!iszero){

            }
            printNumber.accept(0);
            iszero=false;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
       while (num<=((n&2)==0?n:n-1)){
            while(iszero||(num&1)!=0){

            }
            printNumber.accept(num);

            synchronized (this) {
                num++;
                iszero = true;
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (num<=((n&2)==0?n-1:n)){

            while(iszero||(num&1)==0){

            }
            printNumber.accept(num);

                num++;
                iszero = true;

        }
    }
}