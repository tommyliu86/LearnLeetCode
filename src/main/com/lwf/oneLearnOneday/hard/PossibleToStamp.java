package com.lwf.oneLearnOneday.hard;

/**
 * 2132. 用邮票贴满网格图
 * @author liuwenfei
 * @date 2023/12/14 8:53
 */
public class PossibleToStamp {
    /**
     * 差分数组的概念，我们用一个数组表示前缀和变化，如果对其中i~j范围内的数都+1，则我们只要在i处+1，在j处-1，就表示了整体情况
     */
    class Solution {

        public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] presum=new int[m +1][n +1];
            int[][] diff=new int[m +1][n +1];
            //前缀和
            for (int i = 1; i < presum.length; i++) {
                for (int j = 1; j < presum[i].length; j++) {
                    presum[i][j]=grid[i-1][j-1]+presum[i-1][j]+presum[i][j-1]-presum[i-1][j-1];
                }
            }
            // 2. 计算二维差分
            // 为方便第 3 步的计算，在 d 数组的最上面和最左边各加了一行（列），所以下标要 +1
            int[][] d = new int[m + 2][n + 2];
            for (int i2 = stampHeight; i2 <= m; i2++) {
                for (int j2 = stampWidth; j2 <= n; j2++) {
                    int i1 = i2 - stampHeight + 1;
                    int j1 = j2 - stampWidth + 1;
                    //空间中都是0，则可以放入一个邮票，
                    if (presum[i2][j2] - presum[i2][j1 - 1] - presum[i1 - 1][j2] + presum[i1 - 1][j1 - 1] == 0) {
                        d[i1][j1]++;
                        d[i1][j2 + 1]--;
                        d[i2 + 1][j1]--;
                        d[i2 + 1][j2 + 1]++;
                    }
                }
            }

            // 3. 还原二维差分矩阵对应的计数矩阵（原地计算）
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    d[i + 1][j + 1] += d[i + 1][j] + d[i][j + 1] - d[i][j];
                    if (grid[i][j] == 0 && d[i + 1][j + 1] == 0) {
                        return false;
                    }
                }
            }
            return true;


        }
    }
}
