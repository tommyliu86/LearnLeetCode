package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuwenfei
 * @date 2023/8/24 8:53
 */
public class CountServers {
    /**
     * 遍历解法中，一般还是要考虑多次遍历的解决，数量少的情况下，遍历的时间复杂度很好！
     * 计数统计，
     * 思考下，题目是按照行、列有大于1个就可相连，因此这里可以先遍历一次，找到每行、每列的服务器数量，
     * 剩下的思路，就是如何找到答案，
     * 直观的思路是 ：我们如何找到一个服务器，在行和列上重复计数了，这样的话就会变复杂
     * 那反过来，我们直接根据行、列的服务器数量，可以做什么事请?  如果一个服务器的行 or 列>1,那么表示服务器是有连接的，我们计数即可！！！
     */
    class Solution {


        public int countServers(int[][] grid) {
            int[] xmark = new int[grid.length];
            int[] ymark = new int[grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        xmark[i]++;
                        ymark[j]++;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < grid.length; i++)
                for (int j = 0; j < grid[i].length; j++)
                    if (xmark[i] > 1 || ymark[j] > 1) ans++;

            return ans;
        }

    }

    /**
     * 深度优先搜索，n*logn
     */
    class Solution1 {
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
                    while (newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length) {
                        if (grid[newi][newj] == 1) {
                            ps.add(new int[]{newi, newj});
                            grid[newi][newj] = 0;
                            a++;
                        }
                        newi += steps[k - 1];
                        newj += steps[k];
                    }
                }
            }
            return a;
        }
    }
}
