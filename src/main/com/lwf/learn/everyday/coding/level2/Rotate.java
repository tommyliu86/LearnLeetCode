package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 * 旋转图像主要是 坐标 i ，j  如何转动，这里通过一行数据转动到下一个位置更容易找到计算公式
 * @author: liuwenfei14
 * @date: 2022-05-19 16:22
 */
public class Rotate {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = i; j + i < matrix.length - 1; j++) {
                    int x = j;
                    int y = n - i - 1;
                    int num = matrix[i][j];
                    while (x != i || y != j) {
                        int temp = matrix[x][y];
                        matrix[x][y] = num;
                        num = temp;
                        int tempx = x;
                        x = y;
                        y = n - tempx - 1;
                    }
                    matrix[x][y] = num;
                }
            }

        }
    }
}
