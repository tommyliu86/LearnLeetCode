package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * 1738. 找出第 K 大的异或坐标值
 *
 * @author: liuwenfei
 * @date: 2024/5/28-8:49
 */
public class KthLargestValue {
    /**
     * 利用异或操作的特点，进行DP，a^a=0,a^a^b=b,因此，如果异或操作中出现重复元素，相当于没有该元素
     */
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp=new int[m+1][n+1];
            int[] max=new int[m*n];
            int maxi=0;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    dp[i][j]=dp[i-1][j]^dp[i][j-1]^dp[i-1][j-1]^matrix[i-1][j-1];
                    max[maxi++]=(dp[i][j]);
                }
            }
            Arrays.sort(max);

            return max[m*n-k];

        }
    }
}
