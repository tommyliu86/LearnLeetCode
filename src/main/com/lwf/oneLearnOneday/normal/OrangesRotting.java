package com.lwf.oneLearnOneday.normal;

import com.lwf.oneLearnOneday.easy.GenerateTheString;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 994. 腐烂的橘子
 *
 * @author: liuwenfei
 * @date: 2024/5/14-8:42
 */
public class OrangesRotting {
    /**
     * bfs   广度遍历，对橘子数量进行计数
     */
    class Solution {
        public int orangesRotting(int[][] grid) {
            int[] step = new int[]{1, 0, -1, 0, 1};
            int goods = 0;

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        goods++;
                    } else if (grid[i][j] == 2) {
                        int point = i * 10 + j;
                        queue.add(point);
                    }
                }
            }
            if (goods == 0) {
                return 0;
            }
            int count = 0;
            while (!queue.isEmpty()) {
                count++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    int x = poll / 10;
                    int y = poll % 10;
                    for (int j = 0; j < step.length - 1; j++) {
                        int nx = x + step[j];
                        int ny = y + step[j + 1];

                        if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                            grid[nx][ny] = 2;
                            goods--;
                            queue.add(nx * 10 + ny);
                        }
                    }
                }
            }
            return goods == 0 ? count : -1;
        }
    }
}
