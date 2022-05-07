package com.lwf.learn.everyday.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 11:14
 */
public class MaxSubarraySumCircular {
    /**
     * 滑动窗口，
     */
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int N = nums.length;


            int[] P = new int[2 * N + 1];
            for (int i = 0; i < 2 * N; ++i) {
                P[i + 1] = P[i] + nums[i % N];
            }

            // Want largest P[j] - P[i] with 1 <= j-i <= N
            // For each j, want smallest P[i] with i >= j-N
            int ans = nums[0];
            // deque: i's, increasing by P[i]
            Deque<Integer> deque = new ArrayDeque();
            deque.offer(0);

            for (int j = 1; j <= 2 * N; ++j) {
                // If the smallest i is too small, remove it.
                if (deque.peekFirst() < j - N){
                    deque.pollFirst();
                }

                // The optimal i is deque[0], for cand. answer P[j] - P[i].
                ans = Math.max(ans, P[j] - P[deque.peekFirst()]);

                // Remove any i1's with P[i2] <= P[i1].
                while (!deque.isEmpty() && P[j] <= P[deque.peekLast()])
                    deque.pollLast();

                deque.offerLast(j);
            }

            return ans;


        }
    }
}
