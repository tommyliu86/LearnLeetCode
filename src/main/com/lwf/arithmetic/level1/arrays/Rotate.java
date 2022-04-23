package com.lwf.arithmetic.level1.arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-10 17:29
 */
public class Rotate {
    /**
     * 根据旋转图解得出结论： 顺时针旋转的逻辑 x,y->第x行的第j个，会到达 n-x 列的第j个。
     * 找到状态变化方程，即可直接进行遍历了。注意变幻时，从最外层向内进行变化，一次变化一个正方形，且正方形逐步变小！
     */
    class Solution {
        public void rotate(int[][] matrix) {
            int step = matrix.length - 1;

            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = i; j < matrix[i].length - i - 1; j++) {
                    int tempNum = matrix[i][j];
                    int nextX = j;
                    int nextY = step - i;
                    while (nextX != i || nextY != j) {
                        int curNum = matrix[nextX][nextY];
                        matrix[nextX][nextY] = tempNum;
                        tempNum = curNum;

                        int temp = nextY;
                        nextY = step - nextX;
                        nextX = temp;
                    }
                    matrix[nextX][nextY] = tempNum;
                }
            }

        }
    }
}
