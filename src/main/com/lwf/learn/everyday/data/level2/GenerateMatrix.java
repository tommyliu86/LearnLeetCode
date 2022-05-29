package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-27 18:54
 */
public class GenerateMatrix {
    class Solution {
        public int[][] generateMatrix(int n) {
            int k = 1;
            int i = 0;
            int[][] rtn = new int[n][n];
            while (i < ((n & 1) == 1 ? n / 2 + 1 : n / 2)) { //根据奇偶数来看要循环的最大值。
                int minx = i;
                int maxx = n - 1 - i;
                int miny = i;
                int maxy = n - 1 - i;
                if (minx == maxx && miny == maxy) { //如果是奇数，最后的最中间会有一个点存在。
                    rtn[minx][miny] = k;

                } else {

                    int x = minx;
                    int y = miny;
                    while (x < maxx || y < maxy) {
                        rtn[x][y] = k++;

                        if (y < maxy) {
                            y++;
                        } else {
                            x++;
                        }
                    }

                    while (x > minx || y > miny) {
                        rtn[x][y] = k++;
                        if (y > miny) {
                            y--;
                        } else {
                            x--;
                        }
                    }
                }

                i++;
            }
            return rtn;
        }
    }
}
