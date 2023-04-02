package com.lwf.offer.two.tow;

public class NumSubarrayProductLessThanK {
    /**
     * 滑动窗口
     */
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k==0) return 0;
            long multi=1;
            int i=0,j=0;
            int ans=0;
            while (j<nums.length){
                multi*=nums[j];
                while (i<=j&&  multi>=k){
                   multi/=nums[i++];
                }
                ans+=j-i+1;
                j++;
            }
            return ans;
        }
    }
}
