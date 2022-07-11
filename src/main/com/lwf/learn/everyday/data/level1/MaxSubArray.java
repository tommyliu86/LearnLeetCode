package com.lwf.learn.everyday.data.level1;

import java.util.function.IntConsumer;

public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max=Integer.MIN_VALUE;
            int count=0;
            for (int i = 0; i < nums.length; i++) {
                count+=nums[i];
                max=Math.max(max,count);
                if (count<0){
                    count=0;
                }
            }
            return max;
        }
    }
}
