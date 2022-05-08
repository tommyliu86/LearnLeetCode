package com.lwf.learn.everyday.coding;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-08 15:59
 */
public class MatrixReshape {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if (r*c!=mat.length*mat[0].length){
                return mat;
            }
            int ml = mat[0].length;
            int[][] rtn=new int[r][c];
            for (int i = 0; i < rtn.length; i++) {
                for (int j = 0; j < rtn[i].length; j++) {
                    int l = i * c + j;
                    int x=l/ml;
                    int y=l%ml;
                    rtn[i][j]=mat[x][y];
                }
            }
            return rtn;
        }
    }
}
