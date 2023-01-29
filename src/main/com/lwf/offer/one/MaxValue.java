package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 10:37
 */
public class MaxValue {
    class Solution {
        public int maxValue(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j]+=Math.max( i==0?0:grid[i-1][j],j==0?0:grid[i][j-1]);
                }
            }
            return grid[grid.length-1][grid[0].length-1];
        }
    }
}
