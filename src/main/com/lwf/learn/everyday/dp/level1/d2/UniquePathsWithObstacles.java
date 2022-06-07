package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-06 11:02
 */
public class UniquePathsWithObstacles {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] path=new int[obstacleGrid.length][obstacleGrid[0].length];
            for (int i = 0; i < path.length; i++) {
                if (obstacleGrid[i][0]==1) {
                    break;
                }
                path[i][0]=1;
            }
            for (int i = 0; i < path[0].length; i++) {
                if (obstacleGrid[0][i]==1){
                    break;
                }
                path[0][i]=1;
            }
            for (int i = 1; i < path.length; i++) {
                for (int j = 1; j < path[i].length; j++) {
                    if (obstacleGrid[i][j]==1){
                        continue;
                    }
                    path[i][j]=path[i-1][j]+path[i][j-1];
                }
            }
            return path[path.length-1][path[0].length-1];
        }
    }
}
