package com.lwf.learn.everyday.data.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 15:47
 */
public class GenerateMatrix {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] rtn = new int[n][n];
            int cur = 1;
            //奇数则+1，偶数则不加
            for (int i = 0; i < n / 2 + ((n & 1) == 1 ? 1 : 0); i++) {

                int minx = i;
                int miny = i;
                int maxx = n - 1 - i;
                int maxy = n - 1 - i;
                for (int k = miny; k <= maxy; k++) {
                    rtn[minx][k] = cur;
                    cur++;
                }
                for (int k = minx + 1; k <= maxx; k++) {
                    rtn[k][maxy] = cur;
                    cur++;
                }
                if (minx < maxx && miny < maxy) {
                    for (int k = maxy - 1; k >= miny; k--) {
                        rtn[maxx][k] = cur;
                        cur++;
                    }
                    for (int k = maxx - 1; k > minx; k--) {
                        rtn[k][miny] = cur;
                        cur++;
                    }

                }

            }
            return rtn;
        }
    }
}
