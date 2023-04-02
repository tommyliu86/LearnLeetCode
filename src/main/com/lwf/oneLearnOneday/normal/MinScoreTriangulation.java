package com.lwf.oneLearnOneday.normal;

public class MinScoreTriangulation {
    /**
     * dp动态规划，通过计算，在区间长度上的遍历，遍历到所有分割的情况即可
     */
    class Solution {
        public int minScoreTriangulation(int[] values) {
            int[][] dp=new int[values.length][values.length];
            for (int l = 2; l < values.length; l++) {
                for (int i = 0; i+l < values.length; i++) {
                    dp[i][i+l]=Integer.MAX_VALUE;
                    for (int j = i+1; j < i + l; j++) {
                        dp[i][i+l]=Math.min(dp[i][i+l],dp[i][j]+dp[j][i+l]+values[i]*values[i+l]*values[j]);
                    }
                }
            }
            return dp[0][values.length-1];
        }
    }
}
