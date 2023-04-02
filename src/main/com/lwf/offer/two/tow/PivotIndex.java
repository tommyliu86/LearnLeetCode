package com.lwf.offer.two.tow;

public class PivotIndex {
    class Solution {
        public int pivotIndex(int[] nums) {
            int[] presum=new int[nums.length+1];
            for (int i = 1; i < presum.length; i++) {
                presum[i]=presum[i-1]+nums[i-1];
            }
            int total=presum[nums.length];
            for (int i = 1; i < presum.length; i++) {
                if (total-presum[i]-presum[i-1]==0){
                    return i-1;
                }
            }
            return -1;
        }
    }
}
