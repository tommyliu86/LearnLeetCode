package com.lwf.classic.two;

import java.util.PriorityQueue;

/**
 * @author liuwenfei
 * @date 2023/6/29 9:11
 */
public class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            inQueue(nums[i]);
        }
    }

    private void inQueue(int i) {
        queue.offer(i);

        while (queue.size() > k) {
            queue.poll();
        }
    }

    public int add(int val) {
        inQueue(val);
        return queue.peek();
    }

}
