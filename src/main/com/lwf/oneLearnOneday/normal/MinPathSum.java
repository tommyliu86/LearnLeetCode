package com.lwf.oneLearnOneday.normal;

/**
 * author Administrator
 * time 2019-10-22-22:13
 * {@link 64.md}
 */
public class MinPathSum {
    /**
     * 递归解法，超时
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        recursive(grid, 0, 0, 0);
        return min;
    }

    private int min = Integer.MAX_VALUE;

    void recursive(int[][] grid, int x, int y, int sum) {
        sum += grid[x][y];
        if (sum >= min) {
            return;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            min = Math.min(min, sum);
            return;
        }
        if (x < grid.length - 1) {
            recursive(grid, x + 1, y, sum);
        }
        if (y < grid[0].length - 1) {
            recursive(grid, x, y + 1, sum);
        }
    }

    /**
     * 根据递归总结求解公式，sum【x,y】=min(sum[x-1,y],sum[x,y-1])，因此可以使用递归/递推来计算出所有路径
     *
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int x=grid.length;
        int y=grid[0].length;
        for (int i = 1; i < x; i++) {
            grid[i][0]+=grid[i-1][0];
        }
        for (int i = 1; i < y; i++) {
            grid[0][i]+=grid[0][i-1];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[x-1][y-1];
    }

}
