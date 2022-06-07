package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-07 09:52
 */
public class MinPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (i==0&&j==0){
                        continue;
                    }
                    if (i==0){
                        grid[i][j]+=grid[i][j-1];
                    }else if (j==0){
                        grid[i][j]+=grid[i-1][j];
                    }else{
                        grid[i][j]+= Math.min(grid[i-1][j],grid[i][j-1]);
                    }
                }
            }
            return grid[grid.length-1][grid[0].length-1];
        }
    }
}
