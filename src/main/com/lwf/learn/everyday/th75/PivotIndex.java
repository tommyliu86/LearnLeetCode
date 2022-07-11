package com.lwf.learn.everyday.th75;

public class PivotIndex {
    class Solution {
        public int pivotIndex(int[] nums) {
            int[] sums=new int[nums.length+1];
            for (int i = 1; i < sums.length; i++) {
                sums[i]=sums[i-1]+nums[i-1];
            }
            for (int i = 0; i < sums.length-1; i++) {
                if (sums[i]==sums[sums.length-1]-sums[i+1]){
                    return i;
                }
            }
            return -1;
        }
    }
}
