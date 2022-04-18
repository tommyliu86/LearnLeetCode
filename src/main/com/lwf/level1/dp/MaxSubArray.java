package com.lwf.level1.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-17 15:39
 */
public class MaxSubArray {
    /**
     * dp转移方程是  dp【i】=dp【i-1】+nums【i】|| nums【i】如果前缀字符串的和小于0，则丢弃不用，直接等于当前i即可
     */
    class dp {
        public int maxSubArray1(int[] nums) {
           int sum=nums[0];
           int max=sum;
            for (int i = 1; i < nums.length; i++) {
                sum=(sum>0?sum:0)+nums[i];
                max=Math.max(max,sum);
            }
           return max;
        }
        public int maxSubArray(int[] nums) {
           int[] dp=new int[nums.length];
           dp[0]=Math.max( nums[0],0);
            for (int i = 1; i < nums.length; i++) {
                dp[i]=dp[i-1]>0?dp[i-1]:0+nums[i];
            }
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; i++) {
                max=Math.max(max,dp[i]);
            }
            return max;
        }
    }
    class Solution {
        public int maxSubArray(int[] nums) {
            int count=0;
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                count+=nums[i];
                max=Math.max(max,count);
                if (count<0) {
                    count = 0;
                }
            }
            return max;
        }
    }
}
