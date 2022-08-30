package com.lwf.oneLearnOneday.easy;

public class Shuffle {
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] rtn=new int[2*n];
            for (int i = 0; i < n; i++) {
                rtn[2*i]=nums[i];
                rtn[2*i+1]=nums[n+i];
            }
            return rtn;
        }
    }
}
