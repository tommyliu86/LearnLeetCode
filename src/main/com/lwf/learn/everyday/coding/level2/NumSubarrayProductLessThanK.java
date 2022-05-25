package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-24 12:55
 */
public class NumSubarrayProductLessThanK {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int multi=1;
            int left=0;
            int count=0;
            for (int i = 0; i < nums.length; i++) {
                multi*=nums[i];
                while (left<=i&&multi>=k){
                    multi/=nums[left];
                    left++;
                }
                count+=i-left+1;
            }
            return count+nums.length-left;
        }
    }
}
