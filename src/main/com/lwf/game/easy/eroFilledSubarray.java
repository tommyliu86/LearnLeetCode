package com.lwf.game.easy;

public class eroFilledSubarray {
    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long rtn=0;
            int l=0;
            while (l<nums.length){
                if (nums[l]!=0){
                    l++;
                    continue;
                }
                int r=l;
                while (r<nums.length&& nums[r]==0){
                    rtn+=(r-l+1);
                    r++;
                }
                l=r;
            }
            return rtn;
        }
    }
}
