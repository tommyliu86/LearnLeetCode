package com.lwf.offer.two;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuwenfei
 * @date 2023/3/27 9:32
 */
public class RecentCounter {
    Queue<Integer> queue;
    int step = 3000;

    public RecentCounter() {
    queue=new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty()&& queue.peek()<t-step){
            queue.poll();
        }
        return queue.size();
    }


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
