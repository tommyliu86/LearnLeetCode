package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-27 10:38
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum=0;
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
                max=Math.max(max,sum);
                if (sum<0){
                    sum=0;
                }
            }
            return max;
        }
    }
}
