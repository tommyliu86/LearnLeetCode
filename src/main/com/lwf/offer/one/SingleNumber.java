package com.lwf.offer.one;

public class SingleNumber {
    /**
     * 按位统计，，或是无进位的加法
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int[] marks=new int[32];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int j=0;
                while (num != 0) {
                    marks[j]+=(num&1);
                    num>>>=1;
                }
            }
            int ans=0;
            for (int i = 0; i < marks.length; i++) {
                int mark = marks[i] % 3;
                ans|=(mark<<i);
            }
            return ans;
        }
    }
}
