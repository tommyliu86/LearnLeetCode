package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-25 12:43
 */
public class NumMatrix {

    int[][] sums;
    public NumMatrix(int[][] matrix) {
        sums=new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1; i < sums.length; i++) {
            for (int j = 1; j < sums[i].length; j++) {
                sums[i][j]=matrix[i-1][j-1]+sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1]-sums[row2+1][col1]-sums[row1][col2+1]+sums[row1][col1];
    }


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
