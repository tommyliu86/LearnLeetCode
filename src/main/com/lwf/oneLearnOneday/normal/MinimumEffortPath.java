package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1631. 最小体力消耗路径
 * https://leetcode.cn/problems/path-with-minimum-effort/solutions/2561904/python3javacgotypescript-yi-ti-yi-jie-bi-75mn/?envType=daily-question&envId=2023-12-11
 *
 * @author liuwenfei
 * @date 2023/12/11 8:56
 */
public class MinimumEffortPath {
    /**
     * 该题的本质是一个图，如果当作 图来处理，可以使用并查集来进行路径连通性判断求解
     * 并查集
     * https://leetcode.cn/problems/path-with-minimum-effort/solutions/2561904/python3javacgotypescript-yi-ti-yi-jie-bi-75mn/?envType=daily-question&envId=2023-12-12
     */
    class Solution {
        public int minimumEffortPath(int[][] heights) {

            int m = heights.length;
            int n = heights[0].length;

            int total = m * n;
            if (total == 1) {
                return 0;
            }
            UnionFind unionFind = new UnionFind(total);
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int index = i * n + j;
                    if (index + 1 < total && j < n - 1) {
                        edges.add(new int[]{index, index + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
                    }
                    if (index + n < total && i < m - 1) {
                        edges.add(new int[]{index, index + n, Math.abs(heights[i][j] - heights[i + 1][j])});
                    }
                }
            }
            edges.sort(Comparator.comparing(i -> i[2]));
            int c = edges.get(0)[2], i = 0;
            while (i < edges.size()) {
                while (i < edges.size() && edges.get(i)[2] == c) {
                    unionFind.union(edges.get(i)[0], edges.get(i)[1]);
                    i++;
                }
                if (unionFind.connected(0, total - 1)) {
                    return c;
                }
                c = edges.get(i)[2];
            }
            return -1;
        }

        class UnionFind {
            int[] parent;

            public UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < parent.length; i++) {
                    parent[i] = i;
                }
            }

            public boolean connected(int i, int j) {
                return find(i) == find(j);
            }

            public void union(int i, int j) {
                int i1 = find(i);
                int j1 = find(j);
                if (i1 == j1) {
                    return;
                }
                if (i1 > j1) {
                    int temp = i1;
                    i1 = j1;
                    j1 = temp;
                }
                parent[j1] = i1;
            }

            /**
             * 查找的过程，同时进行parent的更新，利用递归实现find
             *
             * @param i
             * @return
             */
            public int find(int i) {
                if (parent[i] != i) {
                    parent[i] = find(parent[i]);
                }
                return parent[i];
            }
        }
    }

    /**
     * 这个题不是dp？？这个题不是直接的dp，因为其中只要能够走到最后，那么就可以算一条路径，这样的话，我们就没有状态转移的过程，
     * 递归的深度优先遍历，每次走一条路，记录其中的路径中的最大值，这样会超时。。
     */
    class Solution1 {
        public int minimumEffortPath(int[][] heights) {
            int[][] ints = new int[heights.length][heights[0].length];
            ints[0][0] = 1;
            return max(0, 0, heights, ints);
        }

        int[] steps = new int[]{0, 1, 0, -1, 0};

        /**
         * 当前点出发，走到最后的最佳路径（路径中最大值的最小路径）
         */
        public int max(int x, int y, int[][] heights, int[][] marks) {
            if (x == heights.length - 1 && y == heights[0].length - 1) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < steps.length - 1; i++) {
                int nx = x + steps[i];
                int ny = y + steps[i + 1];
                if (nx >= 0 && nx < heights.length && ny >= 0 && ny < heights[0].length && marks[nx][ny] == 0) {
                    int c = heights[nx][ny] - heights[x][y];
                    c = c < 0 ? c * -1 : c;
                    marks[nx][ny] = 1;
                    int next = max(nx, ny, heights, marks);
                    //从当前点到最后点上的最佳，也就是最小，当前点获取到后续的最下，我们需要从其中获取最小，然后和当前的大者作为返回
                    ans = Math.min(ans, Math.max(c, next));

                    marks[nx][ny] = 0;
                }
            }
            return ans;
        }
    }
}
