package com.lwf.offer.two.tow;

public class MinSubArrayLen {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int i=0,j=0;
            long sum=0;
            int ans=nums.length+1;
            while (j<nums.length){
                sum+=nums[j++];
                if (sum>=target){

                    while (sum>=target){
                        sum-=nums[i++];
                    }
                    ans=Math.min(ans,j-i+1);
                }

            }
            return ans==nums.length+1?0:ans;
        }
    }
}
