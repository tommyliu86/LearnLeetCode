package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode.cn/problems/matrix-block-sum/
 * 二维的前缀和。使用面积相等的方式来进行区域内的sum计算！
 * @author: liuwenfei14
 * @date: 2022-05-16 17:03
 */
public class MatrixBlockSum {
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int[][] sums=new int[mat.length+1][mat[0].length+1];
            for (int i = 1; i < sums.length; i++) {

                for (int j = 1; j < sums[i].length; j++) {
                    sums[i][j]=mat[i-1][j-1]+sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1];
                }
            }

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    int x1= i-k<0?0:(i-k);
                    int x2=(i+k+1)>sums.length-1?sums.length-1:(i+k+1);
                    int y1= j-k<0?0:(j-k);
                    int y2=(j+k+1)>sums[0].length-1?sums[0].length-1:(j+k+1);
                    mat[i][j]=sums[x2][y2]-sums[x1][y2]-sums[x2][y1]+sums[x1][y1];
                }
            }
            return mat;
        }
    }
}
