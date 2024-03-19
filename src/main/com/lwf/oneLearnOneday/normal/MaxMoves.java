package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * 2684. 矩阵中移动的最大次数
 * from home
 * author: liuwu
 * time: 2024/3/16 20:15
 */
public class MaxMoves {
    /**
     * 深度优先遍历+记忆化搜索
     */
    class Solution {
        public int maxMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int max=0;
            for (int i = 0; i < m; i++) {
                max=Math.max(max,dfs(grid,i,0));
                if (max==n-1){
                    return max;
                }
            }
            return max;
        }
        Map<Integer,Integer> map=new HashMap<>();
        private int dfs(int[][] grid, int i,int j) {
            if (j==grid[0].length-1){
                return j;
            }
            int keys = i * 1000 + j;
            if (map.containsKey(keys)) {
                return map.get(keys);
            }
            int max=0;
            for (int k = Math.max(i-1,0); k <= Math.min(grid.length - 1, i + 1); k++) {
                if (grid[k][j+1]>grid[i][j]){
                    max=Math.max(max,dfs(grid, k,j+1));
                }
            }
            map.put(keys, Math.max(j,max));
            return map.get(keys);
        }
    }

    /**
     * dp 动态规划，对每个位子进行遍历检查，记录可以到达的最远距离，
     */
    class Solution1 {
        public int maxMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] mark = new boolean[m][n];
            for (int i = 0; i < mark.length; i++) {
                mark[i][0] = true;
            }
            int ans = 0;
            for (int i = 1; i < n; i++) {
                boolean has = false;
                for (int j = 0; j < m; j++) {
                    if ((j - 1 >= 0 && mark[j - 1][i - 1] && grid[j][i] > grid[j - 1][i - 1])
                            || mark[j][i - 1] && grid[j][i] > grid[j][i - 1]
                            || i + 1 < m && mark[j + 1][i - 1] && grid[j][i] > grid[j + 1][i - 1]) {
                        mark[j][i] = true;
                        has = true;
                    }
                }
                if (has) {

                    ans++;
                }
            }
            return ans;
        }
    }
}
