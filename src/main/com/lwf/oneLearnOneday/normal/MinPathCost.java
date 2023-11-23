package com.lwf.oneLearnOneday.normal;

/**
 * 2304. 网格中的最小路径代价
 * @author liuwenfei
 * @date 2023/11/23 9:08
 */
public class MinPathCost {
    /**
     * dp 动态规划
     *
     */
    class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
            int[][] matrix=new int[grid.length][grid[0].length];
            matrix[0]=grid[0];
            for (int i = 1; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int min=Integer.MAX_VALUE;
                    for (int k = 0; k < grid[i - 1].length; k++) {
                        min = Math.min(matrix[i - 1][k] + moveCost[grid[i - 1][k]][j], min);
                    }
                    matrix[i][j]=  grid[i][j]+min;
                }
            }
            int ans=Integer.MAX_VALUE;
            for (int i = 0; i < matrix[matrix.length - 1].length; i++) {
                ans=Math.min(ans,matrix[matrix.length-1][i]);
            }
            return ans;
        }
    }
}
