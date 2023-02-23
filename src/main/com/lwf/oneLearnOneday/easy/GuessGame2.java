package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/2/23 11:43
 */
public class GuessGame2 {
    class Solution {
        /**
         * 动态规划，从i-j长度中选择的最小计算来向更长的长度计算，
         * @param n
         * @return
         */
        public int getMoneyAmount(int n) {
            int[][] mins=new int[n+1][n+1];
            for (int l = 1; l < n; l++) {
                for (int i = 1; i < n; i++) {
                    int j=i+l;
                    if (j<=n){
                        mins[i][j]= Math.min(i+ mins[ i+1][j],j+mins[i][j-1]);
                        for (int k = i+1; k < j; k++) {
                            mins[i][j]=Math.min(mins[i][j],k+ Math.max(mins[ i][k-1],mins[k+1][j]));
                        }
                    }
                }
            }
            return mins[1][n];
        }
    }

    /**
     * 递归+记忆化，思路是每个都进行遍历下向后拆分，没有剪枝，因此效率不高
     */
    class Solution1 {
        int[][] mins;

        public int getMoneyAmount(int n) {
            if (n == 1) return 0;
            mins = new int[n + 1][n + 1];

            return dfs(1, n);
        }

        public int dfs(int l, int r) {
            if (mins[l][r] != 0) {
                return mins[l][r];
            }
            if (l >= r) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            for (int i = l; i <= r; i++) {
                min = Math.min(min, i + Math.max(dfs(l, i - 1), dfs(i + 1, r)));
            }
            mins[l][r] = min;
            return min;
        }
    }

}
