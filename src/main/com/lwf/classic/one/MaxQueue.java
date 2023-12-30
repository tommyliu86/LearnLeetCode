package com.lwf.classic.one;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liuwenfei
 * @date 2023/2/9 10:39
 */
class MaxQueue {
    Deque<Integer> index=new LinkedList<>();
    int[] ints=new int[10000];
    int i=0,j=0;
    public MaxQueue() {

    }

    public int max_value() {
        return index.isEmpty()?-1:ints[ index.peekFirst()];
    }

    public void push_back(int value) {
        ints[j++]=value;
        while (!index.isEmpty()&&ints[ index.peekLast()]<=value){
            index.pollLast();
        }
        index.offer(j-1);
    }

    public int pop_front() {
        if (index.isEmpty()){
            return -1;
        }
        if (index.peekFirst()==i){
            index.pollFirst();
        }
        return  i==j?-1: ints[i++];
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
