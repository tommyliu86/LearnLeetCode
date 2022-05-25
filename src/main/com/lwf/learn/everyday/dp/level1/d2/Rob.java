package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-25 14:58
 */
public class Rob {
    class Solution {
        public int rob(int[] nums) {
            int[] sum=new int[nums.length+1];
            sum[1]=nums[0];
            for (int i = 2; i < sum.length; i++) {
                sum[i]=Math.max( nums[i-1]+sum[i-2],sum[i-1]);
            }
            return sum[nums.length];
        }
    }
}
