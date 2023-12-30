package com.lwf.classic.two;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {


   int size;
   Queue<Integer>  queue;
   int sum;
    public MovingAverage(int size) {
        this.size=size;
        queue=new LinkedList<>();
        sum=0;
    }

    public double next(int val) {
        if (queue.size()==size){
            Integer poll = queue.poll();
            sum-=poll;
        }
        queue.offer(val);
        sum+=val;
        return (double) sum/queue.size();
    }


/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
