package com.lwf.learn.everyday.data.level1;

public class MatrixReshape {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if (mat.length*mat[0].length!=r*c){
                return mat;
            }
            int[][] rtn=new int[r][c];
            int i=0;
            int s=mat[0].length;
            for (int j = 0; j < rtn.length; j++) {
                for (int k = 0; k < rtn[j].length; k++) {
                    rtn[j][k]=mat[i/s][i%s];
                }
            }
            return rtn;
        }
    }
}
