package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 14:21
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int l=0,r=nums.length-1;
            while (l!=r){
                if (nums[l]+nums[r]==target){
                    return new int[]{nums[l],nums[r]};
                }else if (nums[l]+nums[r]>target){
                    r--;
                }else{
                    l++;
                }
            }
            return new int[0];
        }
    }
}
