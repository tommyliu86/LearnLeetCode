package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-04 10:49
 */
public class MinFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            for (int i = 1; i < matrix.length; i++) {
                int[] ints = matrix[i];
                int[] pre = matrix[i - 1];
                for (int j = 0; j < ints.length; j++) {
                    ints[j]+=Math.min(Math.min(j==0?pre[j]: pre[j-1],pre[j]),j==n-1?pre[j]:pre[j+1]);
                }
            }
            int[] last = matrix[n - 1];
            int min=last[0];
            for (int i = 1; i < last.length; i++) {
                min=Math.min(min,last[i]);
            }
            return min;
        }

    }
}
