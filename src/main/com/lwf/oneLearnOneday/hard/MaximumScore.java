package com.lwf.oneLearnOneday.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1793. 好子数组的最大分数
 * @author: liuwenfei
 * @date: 2024/3/19-8:59
 */
public class MaximumScore {
    class Solution {
        /**
         * 首先尝试暴力解法，找到思路。
         * 1.k的作用是，子数组必须包含k，我们不考虑k时，相当于找所有子数组中的最小值*n的最大值。
         * 2.我们使用单调栈保存最小值的单调递增，这样可以计算出以当前下标i为end的所有最大分数。
         * @param nums
         * @param k
         * @return
         */
        public int maximumScore(int[] nums, int k) {
            Deque<Integer> deque=new LinkedList<>();
            int max=0;
            return 0;
        }
    }
}
