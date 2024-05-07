package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * 741. 摘樱桃
 */
public class CherryPickup {
    /**
     * 该题目等同于同时有两个人从0走到n，两个人最后可以获得的最大分数，因此我们需要考虑同时记录两个点的得分情况，
     * 而两个人如何记录相对位置，是这个dp结构的重点。解决这个问题，该题目就变成了一个标准的dp了
     * 我们考虑从0出发，每个人向前走一步，此时两个人的位置之间没有限制，因此我们可以使用步数来作为两个点的相同记录，然后记录两个点的位置
     */
    class Solution {
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            //使用三维数组记录两个点的dp，第一维是步数，二和三分别表示两个点的x轴的位置
            int[][][] path = new int[2 * n - 1][n][n];
            //初始化每个位置为-1，表示这个位置没有来过，这样就可以不进行计算
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < path[i].length; j++) {
                    Arrays.fill(path[i][j], -1);
                }
            }
            //第一个位置记录
            path[0][0][0] = grid[0][0];
            for (int i = 0; i < path.length - 1; i++) {
                int[][] cur = path[i];
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        //这个组合来过，往下走
                        if (cur[x][y] != -1) {
                            int x1 = x + 1, x11 = i - x;
                            int x2 = x, x22 = i - x + 1;
                            int y1 = y + 1, y11 = i - y;
                            int y2 = y, y22 = i - y + 1;
                            if (x1 < n) {
                                if (y1 < n) {
                                    if (grid[x1][x11] != -1 && grid[y1][y11] != -1) {
                                        path[i + 1][x1][y1] = Math.max(path[i + 1][x1][y1], cur[x][y] + grid[x1][x11] + (x1 == y1 ? 0 : grid[y1][y11]));
                                    }
                                }
                                if (y22 < n) {
                                    if (grid[x1][x11] != -1 && grid[y2][y22] != -1) {
                                        path[i + 1][x1][y2] = Math.max(path[i + 1][x1][y2], cur[x][y] + +grid[x1][x11] + (x1 == y2 ? 0 : grid[y2][y22]));
                                    }
                                }
                            }
                            if (x22 < n) {
                                if (y1 < n) {
                                    if (grid[x2][x22] != -1 && grid[y1][y11] != -1) {
                                        path[i + 1][x2][y1] = Math.max(path[i + 1][x2][y1], cur[x][y] + +grid[x2][x22] + (x2 == y1 ? 0 : grid[y1][y11]));
                                    }
                                }
                                if (y22 < n) {
                                    if (grid[x2][x22] != -1 && grid[y2][y22] != -1) {
                                        path[i + 1][x2][y2] = Math.max(path[i + 1][x2][y2], cur[x][y] + +grid[x2][x22] + (x2 == y2 ? 0 : grid[y2][y22]));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return Math.max(0, path[2 * n - 2][n - 1][n - 1]);
        }
    }

    class Solution1 {
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int[][][] paths = new int[2 * n - 1][n][n];
            for (int i = 0; i < paths.length; i++) {
                for (int j = 0; j < paths[i].length; j++) {
                    Arrays.fill(paths[i][j], -1);
                }
            }
            paths[0][0][0] = grid[0][0];
            for (int i = 1; i < paths.length; i++) {
                for (int j = Math.max(i - n + 1, 0); j <= Math.min(i, n - 1); j++) {
                    int ax = j;
                    int ay = i - j;
                    if (grid[ax][ay] == -1) {
                        continue;
                    }
                    for (int k = Math.max(i - n + 1, 0); k <= j; k++) {
                        int bx = k;
                        int by = i - k;
                        if (grid[bx][by] == -1) {
                            continue;
                        }
                        int pre1 = paths[i - 1][ax][bx];
                        if (ax > 0) {
                            pre1 = Math.max(pre1, paths[i - 1][ax - 1][bx]);
                        }
                        if (bx > 0) {
                            pre1 = Math.max(pre1, paths[i - 1][ax][bx - 1]);
                        }
                        if (ax > 0 && bx > 0) {
                            pre1 = Math.max(pre1, paths[i - 1][ax - 1][bx - 1]);
                        }
                        if (pre1 != -1) {

                            pre1 += grid[ax][ay];
                            if (ax != bx) {
                                pre1 += grid[bx][by];
                            }
                            paths[i][j][k] = pre1;
                        }
                    }
                }
            }
            return paths[2 * n - 2][n - 1][n - 1] == -1 ? -1 : paths[2 * n - 2][n - 1][n - 1];
        }
    }

    /**
     * 单独计算来回的两次最大，由于这样计算时没有考虑两个路径的相互影响，因此不是最大max
     * 题目其实相当于从0到n走了两遍，因此我们可以使用dp，记录下第一次和第二次走两次的最大值。
     * 但是这样会因为没有记录两次路线之间的相互影响，导致超过最大。
     */
    class Solution2 {
        public int cherryPickup(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] paths = new int[m][n];
            for (int i = 0; i < paths.length; i++) {
                Arrays.fill(paths[i], -1);
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != -1) {
                        int left = i > 0 ? paths[i - 1][j] : 0;
                        int up = j > 0 ? paths[i][j - 1] : 0;
                        if (left == -1 && up == -1) {
                            continue;
                        }
                        paths[i][j] = Math.max(left, up) + grid[i][j];
                    }
                }
            }
            int max1 = paths[m - 1][n - 1];
            if (max1 == -1) {
                return 0;
            }
            int i = m - 1;
            int j = n - 1;
            int mid = max1;
            while (i > 0 || j > 0) {
                mid -= grid[i][j];
                grid[i][j] = 0;
                int left = i - 1 < 0 ? -1 : paths[i - 1][j];
                if (left == mid) {
                    i--;
                } else {
                    j--;
                }
            }
            grid[i][j] = 0;

            for (i = 0; i < grid.length; i++) {
                for (j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != -1) {
                        int left = i > 0 ? grid[i - 1][j] : 0;
                        int up = j > 0 ? grid[i][j - 1] : 0;
                        if (left == -1 && up == -1) {
                            continue;
                        }
                        grid[i][j] = Math.max(left, up) + grid[i][j];
                    }
                }
            }
            return max1 + grid[m - 1][n - 1];
        }
    }
}
