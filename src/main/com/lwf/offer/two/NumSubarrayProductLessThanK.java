package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/3/1 19:54
 */
public class NumSubarrayProductLessThanK {
    /**
     * 通用公式总结，计算每一位为终点的子数组个数 就等于 j-i，因此滑动窗口保持小于k，然后累加即可
     */
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k==0) return 0;
            int count=0;
            int i=0,j=0;
            long sum=1;
            while (j<nums.length){
                sum*=nums[j++];
                while (sum>=k&&i<j){
                   sum/=nums[i++];
                }
                count+=(j-i);
            }
            return count;
        }
    }
}
