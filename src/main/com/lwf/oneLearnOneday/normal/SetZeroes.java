package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/9/30 8:56
 */
public class SetZeroes {

    class Solution {
        public void setZeroes(int[][] matrix) {

            int[] cols = new int[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                boolean rows = false;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        rows = true;
                        cols[j] = 1;

                    }
                }
                if (rows) {
                    Arrays.fill(matrix[i], 0);
                }
            }
            for (int i = 0; i < cols.length; i++) {
                if (cols[i] == 1) {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
}

