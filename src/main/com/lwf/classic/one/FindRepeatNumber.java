package com.lwf.classic.one;

public class FindRepeatNumber {
    class Solution {
        public int findRepeatNumber(int[] nums) {

            for (int i = 0; i < nums.length; i++) {
                int index = nums[i]%100000;
                if (nums[index]>=100000){
                    return index;
                }else{
                    nums[index]+=100000;
                }
            }
            return -1;
        }
    }
}
