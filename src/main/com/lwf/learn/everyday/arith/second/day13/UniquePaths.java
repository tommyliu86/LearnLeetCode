package com.lwf.learn.everyday.arith.second.day13;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-25 10:43
 */
public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] mark=new int[m][n];
            for (int i = 0; i < mark[0].length; i++) {
                mark[0][i]=1;
            }
            for (int i = 0; i < mark.length; i++) {
                mark[i][0]=1;
            }
            for (int i = 1; i < mark.length; i++) {
                for (int j = 1; j < mark[i].length; j++) {
                    mark[i][j]=mark[i-1][j]+mark[i][j-1];
                }
            }
            return mark[m-1][n-1];
        }
    }
}
