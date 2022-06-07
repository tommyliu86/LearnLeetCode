package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-05 10:08
 */
public class MatrixBlockSum {
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int xl = mat.length;
            int yl = mat[0].length;
            int[][] sum=new int[xl+1][yl+1];
            for (int i = 1; i < sum.length; i++) {
                for (int j = 1; j < sum[i].length; j++) {
                    sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+mat[i-1][j-1];
                }
            }
            int[][] rtn=new int[xl][yl];
            for (int i = 0; i < rtn.length; i++) {
                for (int j = 0; j < rtn[i].length; j++) {
                    int px=i-k<0?0:i-k;
                    int py=j-k<0?0:j-k;
                    int cx=i+k+1>xl?xl:i+k+1;
                    int cy=j+k+1>yl?yl:j+k+1;
                    rtn[i][j]=sum[cx][cy]-sum[cx][py]-sum[px][cy]+sum[px][py];
                }
            }
            return rtn;
        }
    }
}
