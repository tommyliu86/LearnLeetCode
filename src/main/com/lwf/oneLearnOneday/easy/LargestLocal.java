package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/3/1 18:44
 */
public class LargestLocal {
    class Solution {
        public int[][] largestLocal(int[][] grid) {
            for (int i = grid.length-1; i > 0; i--) {
                for (int j = grid[i].length-1; j > 0; j--) {
                    grid[i][j]=Math.max(grid[i][j],Math.max(grid[i][j-1],Math.max(grid[i-1][j-1],grid[i-1][j])));
                }
            }
            int[][] ans=new int [grid.length-2][grid[0].length-2];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    ans[i][j]=Math.max(grid[i+1][j+1],Math.max(grid[i+1][j+2],Math.max(grid[i+2][j+2],grid[i+2][j+1])));
                }
            }
            return ans;
        }
    }
}
