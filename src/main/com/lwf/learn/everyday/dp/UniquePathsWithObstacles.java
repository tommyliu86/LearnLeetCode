package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-17 09:36
 */
public class UniquePathsWithObstacles {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            boolean has1 = false;
            for (int i = 1; i < obstacleGrid.length; i++) {
                if (has1) {
                    obstacleGrid[i][0] = 0;
                } else {

                    if (obstacleGrid[i][0] == 1) {
                        obstacleGrid[i][0] = 0;
                        has1 = true;
                    } else {
                        obstacleGrid[i][0] = 1;
                    }
                }
            }
            has1 = false;
            for (int i = 0; i < obstacleGrid[0].length; i++) {
                if (has1) {
                    obstacleGrid[0][i] = 1;
                } else {
                    if (obstacleGrid[0][i] == 1) {
                        obstacleGrid[0][i] = 0;
                        has1 = true;
                    } else {
                        obstacleGrid[0][i] = 1;
                    }
                }
            }
            for (int i = 1; i < obstacleGrid.length; i++) {
                for (int j = 1; j < obstacleGrid[i].length; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
            return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

        }
    }
}
