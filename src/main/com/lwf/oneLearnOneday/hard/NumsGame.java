package com.lwf.oneLearnOneday.hard;

import java.util.PriorityQueue;

/**
 * LCP 24. 数字游戏
 * @author liuwenfei
 * @date 2024/2/1 20:10
 */
public class NumsGame {
    /**
     * https://leetcode.cn/problems/5TxKeK/solutions/2627350/zhuan-huan-zhong-wei-shu-tan-xin-dui-din-7r9b/?envType=daily-question&envId=2024-01-30
     */
    class Solution {
        public int[] numsGame(int[] nums) {
            final int MOD = 1_000_000_007;
            int[] ans = new int[nums.length];
            PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // 维护较小的一半，大根堆
            PriorityQueue<Integer> right = new PriorityQueue<>(); // 维护较大的一半，小根堆
            long leftSum = 0, rightSum = 0;
            for (int i = 0; i < nums.length; i++) {
                int b = nums[i] - i;
                if (i % 2 == 0) { // 前缀长度是奇数
                    if (!left.isEmpty() && b < left.peek()) {
                        leftSum -= left.peek() - b;
                        left.offer(b);
                        b = left.poll();
                    }
                    rightSum += b;
                    right.offer(b);
                    ans[i] = (int) ((rightSum - right.peek() - leftSum) % MOD);
                } else { // 前缀长度是偶数
                    if (b > right.peek()) {
                        rightSum += b - right.peek();
                        right.offer(b);
                        b = right.poll();
                    }
                    leftSum += b;
                    left.offer(b);
                    ans[i] = (int) ((rightSum - leftSum) % MOD);
                }
            }
            return ans;
        }
    }


}
