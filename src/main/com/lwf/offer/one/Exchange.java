package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 14:12
 */
public class Exchange {
    class Solution {
        public int[] exchange(int[] nums) {
            int left=0,right=0;
            while (right<nums.length){
                if (nums[right]%2!=0){
                    int temp=nums[right];
                    nums[right]=nums[left];
                    nums[left]=temp;
                    left++;
                }
                    right++;

            }
            return nums;
        }
    }
}
