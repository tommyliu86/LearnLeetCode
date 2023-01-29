package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 10:29
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int sub = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                //sub就是子数组，因此需要先加元素，子数组是否包含前缀，在计算最大值之后进行判断和清零
                sub += nums[i];
                max = Math.max(sub, max);
                if (sub < 0) {
                    sub = 0;
                }
            }
            return max;
        }
    }
}
