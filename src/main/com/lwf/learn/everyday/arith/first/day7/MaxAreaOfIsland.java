package com.lwf.learn.everyday.arith.first.day7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-06 13:58
 */
public class MaxAreaOfIsland {
    /**
     * dfs 深度优先遍历
     */
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        max = Math.max(max, getMax(i, j, grid));
                    }
                }
            }
            return max;
        }

        int[] xStep = new int[]{-1, 1, 0, 0};
        int[] yStep = new int[]{0, 0, -1, 1};

        private int getMax(int x, int y, int[][] grid) {
            int max = 1;
            for (int i = 0; i < 4; i++) {
                int newX = x + xStep[i];
                int newY = y + yStep[i];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                    grid[newX][newY] = 0;
                    max += getMax(newX, newY, grid);
                }
            }
            return max;
        }
    }

    /**
     * bfs
     */
    class bfs {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        max = Math.max(max, getMax(i, j, grid));
                    }
                }
            }
            return max;
        }

        int[] xStep = new int[]{-1, 1, 0, 0};
        int[] yStep = new int[]{0, 0, -1, 1};

        private int getMax(int x, int y, int[][] grid) {
            int max = 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});
            grid[x][y] = 0;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                max++;
                for (int i = 0; i < 4; i++) {
                    int newX = poll[0] + xStep[i];
                    int newY = poll[1] + yStep[i];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                        grid[newX][newY] = 0;
                        ((LinkedList<int[]>) queue).add(new int[]{newX, newY});
                    }
                }
            }
            return max;
        }
    }
}
