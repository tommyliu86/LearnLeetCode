package com.lwf.oneLearnOneday.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liuwenfei
 * @date 2023/7/21 10:10
 */
public class FindMaxValueOfEquation {
    //单调队列，双端队列比较
    class Solution {
        public int findMaxValueOfEquation(int[][] points, int k) {
            int res = Integer.MIN_VALUE;
            Deque<int[]> queue = new ArrayDeque<int[]>();
            for (int[] point : points) {
                int x = point[0], y = point[1];
                while (!queue.isEmpty() && x - queue.peekFirst()[1] > k) {
                    queue.pollFirst();
                }
                if (!queue.isEmpty()) {
                    res = Math.max(res, x + y + queue.peekFirst()[0]);
                }
                while (!queue.isEmpty() && y - x >= queue.peekLast()[0]) {
                    queue.pollLast();
                }
                queue.offer(new int[]{y - x, x});
            }
            return res;
        }
    }


}
