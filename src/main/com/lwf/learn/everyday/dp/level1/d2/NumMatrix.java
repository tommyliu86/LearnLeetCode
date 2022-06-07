package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-05 15:16
 */
public class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        sums=new int[x+1][y+1];
        for (int i = 1; i < sums.length; i++) {
            for (int j = 1; j < sums[i].length; j++) {
                sums[i][j]=sums[i][j-1]+sums[i-1][j]+matrix[i-1][j-1]-sums[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1]-sums[row2+1][col1]-sums[row1][col2+1]+sums[row1][col1];
    }

}
