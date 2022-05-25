package com.lwf.learn.everyday.arith.second.day5;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-17 12:12
 */
public class MinSubArrayLen {
    /**
     * 双指针--滑动窗口法
     */
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum=0;
            int left=0;
            int right=0;
            int min=nums.length+1;
            while (right<nums.length){
                sum+=nums[right];
                if (sum>=target){

                    while (left<nums.length&& sum>=target){
                        sum-=nums[left];
                        left++;
                    }
                    min=Math.min(min,right-left+2);
                }
                right++;
            }
            return min==nums.length+1?0:min;
        }
    }
}
