package com.lwf.oneLearnOneday.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 10:15
 */
public class RecentCounter {

    Queue<Integer> queue;
    int count = 0;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        count++;
        while (t - queue.peek() > 3000) {
            queue.poll();
            count--;
        }
        return count;
    }
}
