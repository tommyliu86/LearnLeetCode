package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-16 14:31
 */
public class MinFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            for (int i = 1; i < matrix.length; i++) {
               int[] pre=matrix[i-1];
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j]+=(j==0? Math.min(pre[j],pre[j+1]):j==pre.length-1?Math.min(pre[j],pre[j-1]):Math.min(pre[j], Math.min(pre[j+1],pre[j-1])));

                }
            }
            int min=Integer.MAX_VALUE;
            int[] l = matrix[matrix.length - 1];
            for (int i = 0; i < l.length; i++) {
                min=Math.min(l[i],min);
            }
            return min;
        }
    }
}
