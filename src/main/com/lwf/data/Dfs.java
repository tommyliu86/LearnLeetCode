package com.lwf.data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 深度搜索优先算法  dfs
 *
 * @author liuwenfei
 * @date 2023/8/24 9:10
 */
public class Dfs {
    /**
     * 深度优先搜索，解决相邻位置的问题，
     */
    class Solution {
        int[] steps = new int[]{0, 1, 0, -1, 0};

        public int countServers(int[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        int a = dfs(i, j, grid);
                        if (a > 1) ans += a;
                    }
                }
            }
            return ans;
        }

        private int dfs(int i, int j, int[][] grid) {
            Queue<int[]> ps = new LinkedList<>();
            ps.add(new int[]{i, j});
            grid[i][j] = 0;
            int a = 1;
            while (!ps.isEmpty()) {
                int[] poll = ps.poll();
                for (int k = 1; k < steps.length; k++) {
                    int newi = poll[0] + steps[k - 1];
                    int newj = poll[1] + steps[k];
                    if (newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length && grid[newi][newj] == 1) {
                        ps.add(new int[]{newi, newj});
                        grid[newi][newj] = 0;
                        a++;
                    }
                }
            }
            return a;
        }
    }
}
