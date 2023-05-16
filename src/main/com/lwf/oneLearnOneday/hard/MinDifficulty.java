package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/5/16 9:07
 */
public class MinDifficulty {
    public static void main(String[] args) {
        new Solution().minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2);
    }

    static
    class Solution {
        public int minDifficulty(int[] jobDifficulty, int d) {
            if (jobDifficulty.length < d) return -1;
            if (jobDifficulty.length == d) return Arrays.stream(jobDifficulty).sum();
            int l = jobDifficulty.length;
            int[][] maz = new int[l + 1][l + 1];
            for (int i = 1; i < maz.length; i++) {
                maz[i][i] = jobDifficulty[i - 1];
                for (int j = i + 1; j < maz[i].length; j++) {
                    maz[i][j] = Math.max(maz[i][j - 1], jobDifficulty[j - 1]);
                }
            }
            //先初始化只分隔一份的情况，因为这个无法用dp公式
            int[][] dp = new int[d + 1][l + 1];
            for (int i = 0; i < dp[1].length; i++) {
                dp[1][i] = maz[1][i];
            }
            //i表示分隔为几份，j表示长度到j时，分隔为i份的最小分隔法
            for (int i = 2; i < dp.length; i++) {
                for (int j = i; j < dp[i].length; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i - 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + maz[k + 1][j]);
                    }
                }
            }
            return dp[d][l];
        }
    }
}
