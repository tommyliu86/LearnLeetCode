package com.lwf.classic.two;

/**
 * @author liuwenfei
 * @date 2023/3/2 11:26
 */
public class PivotIndex {
    /**
     * 前缀和
     */
    class Solution {
        public int pivotIndex(int[] nums) {
            int[] sums=new int[nums.length+1];
            for (int i = 1; i < sums.length; i++) {
                sums[i]=sums[i-1]+nums[i-1];
            }
            int sum=sums[sums.length];
            for (int i = 1; i < sums.length; i++) {
                if (sums[i-1]==sum-sums[i-1]-nums[i-1]){
                    return i-1;
                }
            }
            return -1;
        }
    }
}
