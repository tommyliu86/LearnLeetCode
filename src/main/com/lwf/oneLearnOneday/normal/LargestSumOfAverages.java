package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/11/28 9:03
 */
public class LargestSumOfAverages {

    /**
     * dp 的状态转移  f(k)= max(f(k-1)+多拆分出来的数组的平均值）
     */
    static
    class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            double[] sums = new double[nums.length + 1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            double[][] dps = new double[nums.length + 1][k + 1];
            //预先计算，因为下方的循环时，默认是存在上一个k-1的分组的，
            for (int i = 1; i < dps.length; i++) {
                dps[i][1] = sums[i] / i;
            }
            int curK = 1;
            while (curK < k) {
                curK++;
                //元素个数不能小于当前k,
                for (int i = curK; i < dps.length; i++) {
                    //每一层上的最后一组元素的个数，可以从curk 到i的index计算的。
                    for (int j = curK - 1; j < i; j++) {
                        dps[i][curK] = Math.max(dps[i][curK], dps[j][curK - 1] + (sums[i] - sums[j]) / (i - j));
                    }
                }
            }
            return dps[nums.length][k];
        }

    }

    class Solution1 {
        public double largestSumOfAverages(int[] nums, int k) {
            int n = nums.length;
            double[] prefix = new double[n + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            double[][] dp = new double[n + 1][k + 1];
//            for (int i = 1; i <= n; i++) {
//                dp[i][1] = prefix[i] / i;
//            }
            for (int j = 1; j <= k; j++) {
                for (int i = j; i <= n; i++) {
                    for (int x = j - 1; x < i; x++) {
                        dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
                    }
                }
            }
            return dp[n][k];
        }
    }

}
