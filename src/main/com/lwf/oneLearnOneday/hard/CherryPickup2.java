package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * 1463. 摘樱桃 II
 *
 * @author: liuwenfei
 * @date: 2024/5/8-8:39
 */
public class CherryPickup2 {
    /**
     * 还是DP解法，我们pre 和cur进行dp的记录，每次从pre中向下走找到可以到达的位置即可
     */
    class Solution {
        public int cherryPickup(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][][] pos = new int[m][n][n];
            for (int i = 0; i < pos.length; i++) {
                for (int j = 0; j < pos[i].length; j++) {
                    Arrays.fill(pos[i][j], -1);
                }
            }
            pos[0][0][n - 1] = grid[0][0] + grid[0][n - 1];

            for (int i = 0; i < m - 1; i++) {
                int[][] cur = pos[i];
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        if (cur[x][y] != -1) {
                            int x1 = x - 1, x2 = x, x3 = x + 1;
                            int y1 = y - 1, y2 = y, y3 = y + 1;
                            if (x1 >= 0) {
                                if (y1 >= 0) {
                                    max(x1, y1, i + 1, pos, cur[x][y], grid);
                                }
                                max(x1, y2, i + 1, pos, cur[x][y], grid);
                                if (y3 < n) {
                                    max(x1, y3, i + 1, pos, cur[x][y], grid);
                                }
                            }
                            {
                                if (y1 >= 0) {
                                    max(x2, y1, i + 1, pos, cur[x][y], grid);
                                }
                                max(x2, y2, i + 1, pos, cur[x][y], grid);
                                if (y3 < n) {
                                    max(x2, y3, i + 1, pos, cur[x][y], grid);
                                }
                            }
                            if (x3 < n) {
                                if (y1 >= 0) {
                                    max(x3, y1, i + 1, pos, cur[x][y], grid);
                                }
                                max(x3, y2, i + 1, pos, cur[x][y], grid);
                                if (y3 < n) {
                                    max(x3, y3, i + 1, pos, cur[x][y], grid);
                                }
                            }
                        }
                    }
                }
            }
            int[][] po = pos[m - 1];
            int ans =0;
            for (int i = 0; i < po.length; i++) {
                for (int j = 0; j < po[i].length; j++) {
                    ans=Math.max(ans,po[i][j]);
                }
            }
            return ans;
        }

        public void max(int x, int y, int i, int[][][] pos, int cur, int[][] grid) {
            pos[i][x][y] = Math.max(pos[i][x][y], cur + grid[i][x] + (x == y ? 0 : grid[i][y]));
        }
    }
}
