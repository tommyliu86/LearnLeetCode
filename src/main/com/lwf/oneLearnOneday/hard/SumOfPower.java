package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/8/1 8:29
 */
public class SumOfPower {
    class Solution {
        /**
         * 最小值组成前缀和，这个前缀和如何计算的问题：
         * 思路1：尾数为 j则最大已经确定，因此我们考虑从0开始的起点，每个i<j,可以组合多少子序列，假设 i到j中间有3个数，每个数可选可不选，因此就是简单的阶乘了
         * 思路2：每次j为最大，假设dp[j]是最小值的和，在j处 power=dp[j]*j，那j+1时，dp[j+1]=dp[j]+j,对于j+1，比j多了的一个最小值是j本身，因此把j加上即可
         * 每个位置的最小值都会对后面的j产生贡献，因此前缀和会累加滚动。这个思路不如第一个清晰。。。
         * 这样就是一个dp动态了
         *
         * @param nums
         * @return
         */
        public int sumOfPower(int[] nums) {
            Arrays.sort(nums);
            //最小值的和前缀
            long[] dp = new long[nums.length + 1];

            long res = 0, mod = 1000000007;
            for (int i = 0; i < nums.length; i++) {
                //转成long计算，否则会溢出。
                long num = nums[i];
                dp[i + 1] = ( num + 2 * dp[i]) % mod;
                res = (res + num * num % mod * (dp[i] + num)) % mod;

            }
            return (int) res;
        }
    }

    class Solution1 {
        /**
         * 最小值组成前缀和，这个前缀和如何计算的问题：
         * 思路1：尾数为 j则最大已经确定，因此我们考虑从0开始的起点，每个i<j,可以组合多少子序列，假设 i到j中间有3个数，每个数可选可不选，因此就是简单的阶乘了
         * 思路2：每次j为最大，假设dp[j]是最小值的和，在j处 power=dp[j]*j，那j+1时，dp[j+1]=dp[j]+j,对于j+1，比j多了的一个最小值是j本身，因此把j加上即可
         * 每个位置的最小值都会对后面的j产生贡献，因此前缀和会累加滚动。这个思路不如第一个清晰。。。
         * 这样就是一个dp动态了
         *
         * @param nums
         * @return
         */
        public int sumOfPower(int[] nums) {
            Arrays.sort(nums);
            //最小值的和
            int[] dp = new int[nums.length];
            //所有前缀的最小值和的和
            int[] preSum = new int[nums.length + 1];
            int res = 0, mod = 1000000007;
            for (int i = 0; i < nums.length; i++) {
                dp[i] = (nums[i] + preSum[i]) % mod;
                preSum[i + 1] = (preSum[i] + dp[i]) % mod;
                res = (int) ((res + (long) nums[i] * nums[i] % mod * dp[i]) % mod);
                if (res < 0) {
                    res += mod;
                }
            }
            return res;
        }
    }
}
