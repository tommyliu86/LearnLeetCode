package com.lwf.oldtime;




import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1.使用sync锁，以及this。wait/notifyall方法的组合，也就是所有线程循环同样次数，但是even和odd会
 * 根据当前的标记进行打印与否
 * 2.使用reentrantlock和condition，控制3个线程交替，但是在提交时候会有一个 your input envalid，exiting
 * 3.后期进行优化看看！
 * 4.使用共享变量方法，无法保证两个标记的原子性？试试用atomic家族？这个家族只能保证一个值的原子性。
 */
public class ZeroEvenOdd {

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    volatile int num=1;
    volatile boolean iszero=true;
    Object lock=new Object();

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
                synchronized (lock) {
                    while (!iszero) {
                        this.wait();
                    }
                    printNumber.accept(0);
                    iszero = false;
                   this.notifyAll();
                }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
       for (int i=2;i<=n ;i+=2){
           synchronized (lock) {
               while (iszero||(num&1)==1) {
                   this.wait();
               }
               printNumber.accept(num);
               iszero = false;
               num++;
               this.notifyAll();
           }


        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
       for(int i=1;i<=n;i+=2){

           synchronized (lock) {
               while (iszero||(num&1)==0) {
                   this.wait();
               }
               printNumber.accept(num);
               iszero = false;
               num++;
               this.notifyAll();
           }

       }
    }
}