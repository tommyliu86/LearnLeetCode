package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 14:53
 */
public class MaxProduct {
    class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            int min = nums[0];
            int m = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int nmax = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
                int nmin = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
                max = nmax;
                min = nmin;
                m = Math.max(m, max);
            }
            return m;
        }
    }
}
