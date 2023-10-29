package com.lwf.data;

import java.util.Arrays;

/**
 * 0-1背包问题
 */
public class DPBag {
    /**
     * 目标和  背包问题
     * https://leetcode.cn/problems/YaVDxD/
     * https://leetcode.cn/problems/target-sum/description/
     */
    class Solution {
        // 题目中相当于 选择一批 元素 被减去，最终结果==target，因此 可得到 负号的元素和neg =（sum-target)/2
        public int findTargetSumWays1(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            int neg = (sum - target) ;
            if (neg < 0||neg%2!=0) return 0;
            neg/=2;
            //此时题目变成了从 nums 中 选择元素，和==neg，因此每个元素都可选或不可选的可能 0-1背包就是这个意思
            int[][] dp = new int[nums.length + 1][neg + 1];
            dp[0][0]=1;

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                //dp[i][j]表示的是当前i个元素中选取的组合的和是j 的组合个数
                //因此 j<num的 当前num不能选择
                //j>=num 时，则当前位置的可能选择 和不选择。
                for (int j = 0; j <=neg; j++) {
                    dp[i + 1][j] = dp[i][j];
                    if (j>=num){
                        dp[i + 1][j] += dp[i][j - num];
                    }
                }
            }
            return dp[nums.length][neg];

        }
        // dp数组优化成1维数组
        public int findTargetSumWays(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            int neg = (sum - target) ;
            if (neg < 0||neg%2!=0) return 0;
            neg/=2;
            //此时题目变成了从 nums 中 选择元素，和==neg，因此每个元素都可选或不可选的可能 0-1背包就是这个意思
            int[] dp = new int[neg + 1];
            dp[0]=1;

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                //dp[j]表示的是当前i个元素中选取的组合的和是j 的组合个数
                //因此 j<num的 当前num不能选择
                //j>=num 时，则当前位置的可能选择 和不选择。
                for (int j = neg; j>=num; j--) {

                    //使用一个数组，这里需要从大到小计算！
                    dp[j] += dp[j - num];

                }
            }
            return dp[neg];

        }
    }

}
