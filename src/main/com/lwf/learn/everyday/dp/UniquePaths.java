package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-17 09:32
 */
public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] path=new int[m][n];
            for (int i = 0; i < path.length; i++) {
                path[i][0]=1;
            }
            for (int i = 0; i < path[0].length; i++) {
                path[0][i]=1;
            }
            for (int i = 1; i < path.length; i++) {
                for (int j = 1; j < path[i].length; j++) {
                    path[i][j]=path[i-1][j]+path[i][j-1];
                }
            }
            return path[m-1][n-1];
        }
    }
}
