package com.lwf.learn.everyday.first.day9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-08 10:47
 */
public class OrangesRotting {
    class Solution {
        /**
         * 广度优先，层序遍历，同时使用计数器记录 ==1的数量，
         * 注意边界条件，先判断 无1用时为0，有1时：无2用时为-1，有2则进行循环向外查找，
         * @param grid
         * @return
         */
        public int orangesRotting(int[][] grid) {
            Queue<int[]> queueFor2 = new LinkedList<>();
            int for1=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        ((LinkedList<int[]>) queueFor2).add(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        for1++;
                    }
                }
            }

            if (for1==0){
                return 0;
            }

            int time = -1;
            while (!queueFor2.isEmpty()) {
                int size = queueFor2.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queueFor2.poll();
                    for (int j = 0; j < 4; j++) {
                        int x = poll[0] + xStep[j];
                        int y = poll[1] + yStep[j];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                            for1--;
                            grid[x][y] = 2;
                            ((LinkedList<int[]>) queueFor2).add(new int[]{x, y});
                        }
                    }
                }
                time++;
            }
            return for1==0 ? time : -1;
        }
        int[] xStep = {-1, 1, 0, 0};
        int[] yStep = {0, 0, -1, 1};

    }
}
