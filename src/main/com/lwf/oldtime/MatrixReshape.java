package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-28-22:55
 * {@link 566.md}
 */
public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r*c!=nums.length*nums[0].length) return nums;
        int[][] rtn=new  int[r][c];
        int row=0;
        int column=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                rtn[row][column++]=nums[i][j];
                if (column>=c) {
                    column=0;
                    row++;
                }
            }
        }
        return rtn;
    }
}
