package com.lwf.oneLearnOneday.normal;

import java.util.PriorityQueue;

/**
 * 2462. 雇佣 K 位工人的总代价
 *
 * @author: liuwenfei
 * @date: 2024/5/9-12:01
 */
public class TotalCost {
    /**
     * 每次选择时候，是从前c+后c中选最小的+index最小，因此可以使用
     */
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            PriorityQueue<Integer> leftQ = new PriorityQueue<>();
            PriorityQueue<Integer> rightQ = new PriorityQueue<>();
            leftQ.add(Integer.MAX_VALUE);
            rightQ.add(Integer.MAX_VALUE);
            long ans = 0;
            int i = 0, j = costs.length - 1;
            while (candidates > 0 && i <= j) {
                candidates--;
                leftQ.add(costs[i++]);
                if (i <= j) {
                    rightQ.add(costs[j--]);
                }
            }
            for (int i1 = 0; i1 < k; i1++) {
                if (leftQ.peek() > rightQ.peek()) {
                    ans += rightQ.poll();
                    if (i <= j) {
                        rightQ.add(costs[j--]);
                    }
                } else {
                    ans += leftQ.poll();
                    if (i <= j) {
                        leftQ.add(costs[i++]);
                    }
                }
            }
            return ans;
        }
    }
}
