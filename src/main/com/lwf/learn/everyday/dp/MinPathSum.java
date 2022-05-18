package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-17 10:18
 */
public class MinPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j]+=i==0&&j==0?0:j==0?grid[i-1][j]:i==0?grid[i][j-1]:Math.min(grid[i][j-1],grid[i-1][j]);

                }
            }
            return grid[grid.length-1][grid[0].length-1];
        }
    }
}
