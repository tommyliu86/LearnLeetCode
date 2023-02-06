package com.lwf.offer.one;

import java.util.PriorityQueue;

/**
 * @author liuwenfei
 * @date 2023/2/1 14:01
 */
class MedianFinder {
    //双优先队列，队列顶保存中位数的两个数即可
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int count=0;
    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        max = new PriorityQueue<>(Integer::compareTo);
        min = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
        if (count==0){
            min.offer(num);
            count++;
            return;
        }
        if (count%2==0){
            if ( max.peek()>=num){
                min.offer(num);
            }else{
                max.offer(num);
                Integer peek = max.poll();
                min.offer(peek);
            }
        }else{
            if ( min.peek()>num){
                min.offer(num);
                Integer peek = min.poll();
                max.offer(peek);
            }else{
                max.offer(num);
            }
        }
        count++;
    }

    public double findMedian() {
        if (count==0) return 0d;
        if (count%2==0){
            return (double)(min.peek()+max.peek())  /2;
        }else{
            return min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */