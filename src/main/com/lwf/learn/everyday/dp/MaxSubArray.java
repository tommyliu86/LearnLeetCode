package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 10:50
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int count = 0;
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                count =Math.max( count+nums[i], nums[i]);
                max=Math.max(count,max);

            }
            return max;
        }
    }
}
