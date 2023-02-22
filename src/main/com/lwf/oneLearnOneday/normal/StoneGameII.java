package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/2/22 9:04
 */
public class StoneGameII {
    /**
     * 动态规划 一般都是正向的公式，也就是f(i)与前面的数值有关系，而这里的是与后面剩余的数据有关！
     * dp动态规划，dp的公式是逆向推导的，先计算大的步进，然后再往小计算。。
     */
    class Solution {
        public int stoneGameII(int[] piles) {
            int n = piles.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + piles[i - 1];
            }
            //i 表示m的值，j表示当前剩余的堆数
            int[][] max = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int m = i + 1;
                    if (2 * m >= (n - j)) {
                        max[i][j] = sum[n] - sum[j];
                    } else {
                        for (int k = 1; k <= 2 * m; k++) {
                            max[i][j] = Math.max(max[i][j], sum[n] - sum[j] - max[Math.max(k, m) - 1][j + k]);
                        }
                    }
                }
            }
            return max[0][0];
        }
    }
}
