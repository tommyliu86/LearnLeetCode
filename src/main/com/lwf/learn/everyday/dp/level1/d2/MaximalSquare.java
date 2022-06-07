package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-07 10:04
 */
public class MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int max=0;
            int[][] m=new int[matrix.length][matrix[0].length];
            for (int i = 0; i < m.length; i++) {
                m[i][0]=matrix[i][0]=='0'?0:1;
                max=Math.max(max,m[i][0]*m[i][0]);
            }
            for (int i = 0; i < m[0].length; i++) {
                m[0][i]=matrix[0][i]=='0'?0:1;
                max=Math.max(max,m[0][i]*m[0][i]);
            }
            for (int i = 1; i < m.length; i++) {
                for (int j = 1; j < m[i].length; j++) {
                    m[i][j]=matrix[i][j]=='0'?0:(  Math.min( Math.min(m[i-1][j-1],m[i][j-1]),m[i-1][j])+1);
                    max=Math.max(max,m[i][j]*m[i][j]);
                }
            }
            return max;
        }
    }
}
