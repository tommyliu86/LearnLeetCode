package com.lwf.oneLearnOneday.normal;

import java.util.PriorityQueue;

/**
 * @author liuwenfei
 * @date 2023/10/18 8:38
 */
public class MaxKelements {
    /**
     * 优先队列的大根堆即可，计算向上取整可以使用 (i+2)/3 这样保证有余数时会向上取整
     */
    class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((a,b)->Integer.compare(b,a));
            for (int num : nums) {
                priorityQueue.offer(num);
            }
            long ans=0;
            for (int i = 0; i < k; i++) {
                Integer poll = priorityQueue.poll();

                ans+=poll;
                priorityQueue.offer((poll+2)/3);
            }
            return ans;
        }
    }
}
