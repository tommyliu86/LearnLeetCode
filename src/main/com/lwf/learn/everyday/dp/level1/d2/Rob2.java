package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-25 15:06
 */
public class Rob2 {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length<2){
                return nums[0];
            }
            int[] sum0=new int[nums.length];
            sum0[0]=nums[0];
            sum0[1]=nums[0];
            int[] sum1=new int[nums.length];
            sum1[1]=nums[1];
            for (int i = 2; i < nums.length; i++) {
                sum0[i]=Math.max( sum0[i-1],sum0[i-2]+nums[i]);
                sum1[i]=Math.max( sum1[i-1],sum1[i-2]+nums[i]);
            }
            return Math.max( sum0[nums.length-2],sum1[nums.length-1]);
        }
    }
}
