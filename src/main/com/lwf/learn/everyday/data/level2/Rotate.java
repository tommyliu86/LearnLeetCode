package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-27 18:27
 */
public class Rotate {
    class Solution {
        /**
         * 行列转换，可以直观的看出顺时针90度的公式， i，j=>（ j，y-i）
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = i; j < n -1- i; j++) {
                    int newx = j;
                    int newy = n - 1 - i;
                    int temp = matrix[i][j];
                    while (newx != i || newy != j) {
                        int t = matrix[newx][newy];
                        matrix[newx][newy] = temp;
                        temp = t;

                        int tx = newx;
                        newx = newy;
                        newy = n-1 - tx;
                    }
                    matrix[i][j] = temp;
                }
            }

        }
    }
}
