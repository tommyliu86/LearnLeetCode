package com.lwf.learn.everyday.th75;

public class RunningSum {
    class Solution {
        public int[] runningSum(int[] nums) {
            int[] rtn=new int[nums.length];
            rtn[0]=nums[0];
            for (int i = 1; i < nums.length; i++) {
                rtn[i]+=rtn[i-1]+ nums[i];
            }
            return rtn;
        }
    }
}
