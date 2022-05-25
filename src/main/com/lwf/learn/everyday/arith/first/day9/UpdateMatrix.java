package com.lwf.learn.everyday.arith.first.day9;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-08 09:37
 */
public class UpdateMatrix {
    /**
     * 反向思路，不查找不是0的节点，而是通过先查找0节点，然后从0节点出发去找最近的非零，这样可以利用层序遍历来计算逐步增加的距离
     */
    class test {
        public int[][] updateMatrix(int[][] mat) {
            Queue<int[]> queue = new LinkedList<>();
            int[][] rtn = new int[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 0) {
                        ((LinkedList<int[]>) queue).add(new int[]{i, j});
                        mat[i][j] = -1;
                        rtn[i][j] = 0;
                    }
                }
            }
            int dis = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    rtn[poll[0]][poll[1]] = dis;
                    for (int j = 0; j < 4; j++) {
                        int newX=poll[0]+xStep[j];
                        int newY=poll[1]+yStep[j];
                        if (newX>=0&&newX<mat.length&&newY>=0&&newY<mat[0].length&&mat[newX][newY]==1){
                            ((LinkedList<int[]>) queue).add(new int[]{newX,newY});
                            mat[newX][newY]=-1;
                        }
                    }
                }
                dis++;
            }
            return rtn;
        }

        int[] xStep = {-1, 1, 0, 0};
        int[] yStep = {0, 0, -1, 1};

    }

    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int[][] rtn = new int[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    rtn[i][j] = find0(mat, i, j);
                }
            }
            return rtn;
        }

        int[] xStep = {-1, 1, 0, 0};
        int[] yStep = {0, 0, -1, 1};

        /**
         * 暴力解法，直接查找不是0的每个节点的周围节点是否=0，超时
         *
         * @param mat
         * @param x
         * @param y
         * @return
         */
        private int find0(int[][] mat, int x, int y) {
            int dis = 0;
            if (mat[x][y] == 0) {
                return dis;
            }
            Queue<int[]> queue = new LinkedList<>();
            List<int[]> mark = new LinkedList<>();
            queue.add(new int[]{x, y});
            mark.add(new int[]{x, y});
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    if (mat[poll[0]][poll[1]] == 0) {
                        return dis;
                    } else {
                        for (int j = 0; j < 4; j++) {
                            int newX = poll[0] + xStep[j];
                            int newY = poll[1] + yStep[j];
                            int[] ints = new int[]{newX, newY};
                            if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length && !mark.contains(ints)) {

                                queue.add(ints);
                                mark.add(ints);
                            }
                        }
                    }
                }
                dis++;
            }
            return dis;
        }
    }
}
