package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-27 09:16
 */
public class PacificAtlantic {
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int[][] leftm = new int[heights.length ][heights[0].length ];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < heights[0].length; i++) {
                queue.add(new int[]{0, i});
                leftm[0][i]=1;
            }
            for (int i = 1; i < heights.length; i++) {
                queue.add(new int[]{i, 0});
                leftm[i][0]=1;
            }
            forLeft(heights, queue, leftm);


           int[][] rightm= new int[heights.length][heights[0].length ];
            for (int i = 0; i < heights[0].length; i++) {
                queue.add(new int[]{heights.length - 1, i});
                rightm[heights.length-1][i]=1;
            }
            for (int i = 0; i < heights.length-1; i++) {
                queue.add(new int[]{i, heights[0].length - 1});
                rightm[i][heights[0].length-1]=1;
            }
            return forRight(heights, queue,rightm,leftm);



        }

        public void forLeft(int[][] heights, Queue<int[]> queue, int[][] mark) {

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    int h = heights[poll[0]][poll[1]];
                    for (int j = 0; j < 4; j++) {
                        int newx = poll[0] + xs[j];
                        int newy = poll[1] + ys[j];
                        if (newx >= 0 && newx < heights.length
                                && newy >= 0 && newy < heights[0].length && heights[newx][newy] >= h && mark[newx][newy] == 0) {
                            mark[newx][newy] = 1;
                            queue.add(new int[]{newx, newy});
                        }
                    }
                }
            }
        }

        public List<List<Integer>> forRight(int[][] heights, Queue<int[]> queue, int[][] mark, int[][] left) {
            List<List<Integer>> rtn = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    if (left[poll[0]][poll[1]] ==1){
                        rtn.add(Arrays.asList(poll[0],poll[1]));
                    }

                    int h = heights[poll[0]][poll[1]];
                    for (int j = 0; j < 4; j++) {
                        int newx = poll[0] + xs[j];
                        int newy = poll[1] + ys[j];
                        if (newx >= 0 && newx < heights.length
                                && newy >= 0 && newy < heights[0].length && heights[newx][newy] >= h && mark[newx][newy] == 0) {
                            mark[newx][newy] = 1;
                            queue.add(new int[]{newx, newy});
                        }
                    }
                }
            }
            return rtn;
        }

        int[] xs = {-1, 1, 0, 0};
        int[] ys = {0, 0, -1, 1};
    }
}
