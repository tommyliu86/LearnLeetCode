package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/3/1 19:42
 */
public class MinSubArrayLen {
    /**
     * 滑动窗口
     */
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int i=0,j=0;
            int sum=0;
            int min=nums.length+4;
            while (j<nums.length){
                sum+=nums[j++];
                if (sum>=target){
                    while (sum>=target){
                        sum-=nums[i++];
                    }
                    min=Math.min( j+1-i,min);
                }

            }
            return min==nums.length+4?0:min;
        }
    }
}
