package com.lwf.oneLearnOneday.easy;

public class MinMaxGame {
    /**
     * 模拟计算
     */
    class Solution {
        public int minMaxGame(int[] nums) {
            int i=nums.length;
            while (i!=1){
                for (int j = 0; j < i/2; j++) {
                    nums[j]= ((j&1)==0)?Math.min(nums[j*2],nums[j*2+1]):Math.max(nums[j*2],nums[j*2+1]);
                }
                i=i/2;
            }
            return nums[0];
        }
    }
}
