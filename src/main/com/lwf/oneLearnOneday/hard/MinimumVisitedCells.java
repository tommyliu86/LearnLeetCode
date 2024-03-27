package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2617. 网格图中最少访问的格子数
 *
 * @author: liuwenfei
 * @date: 2024/3/22-9:00
 */
public class MinimumVisitedCells {
    /**
     * dp 动态规划， 每个位置，可以从left 和up两个方向到达，每个方向到达候，接下来能够到达的最远距离是cur。
     * 因此我们可以直接记录到达cur位置的最小步骤即可。标识只要能够达到，如果是
     * 到达（i，j）时，则我们获取到能够到达i的最小的步数，也就是我们需要一个优先队列，队列中保存着（step,max）每个步数可以到达的最远距离
     */
    class Solution {
        public int minimumVisitedCells(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;
            if (m == 1 && n == 1) {
                return 1;
            }
            int[][] maxDis = new int[m][n];
            //每行的优先队列
            PriorityQueue<int[]>[] pm = new PriorityQueue[m];
            for (int i = 0; i < pm.length; i++) {
                pm[i] = new PriorityQueue<>((a, b) -> {
                    if (a[0] == b[0]) {
                        return Integer.compare(a[1], b[1]);
                    } else {
                        return Integer.compare(a[0], b[0]);
                    }
                });
            }
            //每列的优先队列
            PriorityQueue<int[]>[] pn = new PriorityQueue[n];
            for (int i = 0; i < pn.length; i++) {
                pn[i] = new PriorityQueue<>((a, b) -> {
                    if (a[0] == b[0]) {
                        return Integer.compare(a[1], b[1]);
                    } else {
                        return Integer.compare(a[0], b[0]);
                    }
                });
            }

            maxDis[0][0] = 1;
            pm[0].add(new int[]{1, grid[0][0]});
            pn[0].add(new int[]{1, grid[0][0]});

            for (int i = 0; i < m; i++) {
                PriorityQueue<int[]> rowP = pm[i];
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    while (!rowP.isEmpty() && rowP.peek()[1] < j) {
                        rowP.poll();
                    }
                    int rowMin = -1;
                    if (!rowP.isEmpty()) {
                        int[] peek = rowP.peek();
                        rowMin = peek[0];
                    }
                    //列的优先队列
                    PriorityQueue<int[]> colP = pn[j];

                    while (!colP.isEmpty() && colP.peek()[1] < i) {
                        colP.poll();
                    }
                    int colMin = -1;
                    if (!colP.isEmpty()) {
                        int[] peek = colP.peek();
                        colMin = peek[0];
                    }

                    if (rowMin == -1 && colMin == -1) {
                        continue;
                    } else {
                        int min = Math.min(rowMin == -1 ? Integer.MAX_VALUE : rowMin, colMin == -1 ? Integer.MAX_VALUE : colMin);
                        rowP.add(new int[]{min + 1, j + grid[i][j]});
                        colP.add(new int[]{min + 1, i + grid[i][j]});
                        maxDis[i][j] = min;
                    }
                }
            }
            return maxDis[m - 1][n - 1] == 0 ? -1 : (maxDis[m - 1][n - 1] + 1);

        }
    }
}
