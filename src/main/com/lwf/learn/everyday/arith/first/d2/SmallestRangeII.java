package com.lwf.learn.everyday.arith.first.d2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-27 15:47
 */
public class SmallestRangeII {
    class Solution {
        public int smallestRangeII(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            int rtn=nums[n-1]-nums[0];
            for (int i = 0; i < nums.length-1; i++) {
                int newM=Math.max(nums[i]+k,nums[n-1]-k);
                int newMin=Math.min(nums[0]+k,nums[i+1]-k);
                rtn=Math.min(rtn,Math.abs( newM-newMin));
            }
            return rtn;
        }
    }
}
