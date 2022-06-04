package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 09:15
 */
public class MaxProduct {
    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;


            int multi = 1;
            int minus = 1;
            for (int i = 0; i < nums.length; i++) {
                int nmulti = Math.max(Math.max(multi * nums[i], minus * nums[i]), nums[i]); //有可能前一个数的最大最小都是负数
                int nmin = Math.min(Math.min(multi * nums[i], minus * nums[i]), nums[i]); //有可能前一个数的最大最小都是负数

                multi=nmulti;
                minus=nmin;
                max=Math.max(multi,max);
            }
            return max;
        }
    }
}
