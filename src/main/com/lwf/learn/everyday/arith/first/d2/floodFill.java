package com.lwf.learn.everyday.arith.first.d2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-19 14:55
 */
public class floodFill {
    class Solution1 {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int pre = image[sr][sc];
            if (pre==color){
                return image;
            }

            Queue<int[]> queue = new LinkedList<>();
            image[sr][sc]=color;

            ((LinkedList<int[]>) queue).add(new int[]{sr, sc});
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] pop = ((LinkedList<int[]>) queue).pop();
                    for (int j = 0; j < 4; j++) {
                        int newx=pop[0]+xs[j];
                        int newy=pop[1]+ys[j];
                        if (newx>=0&&newx<image.length&&newy>=0&&newy<image[0].length&&image[newx][newy]==pre){
                            image[newx][newy]=color;
                            queue.add(new int[]{newx,newy});

                        }

                    }
                }
            }
            return image;
        }
        int[] xs=new int[]{-1,1,0,0};
        int[] ys=new int[]{0,0,-1,1};
    }
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int[][] mark=new int[image.length][image[0].length];
            Queue<int[]> queue = new LinkedList<>();
            int pre = image[sr][sc];
            image[sr][sc]=color;
            mark[sr][sc]=1;
            ((LinkedList<int[]>) queue).add(new int[]{sr, sc});
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] pop = ((LinkedList<int[]>) queue).pop();
                    for (int j = 0; j < 4; j++) {
                        int newx=pop[0]+xs[j];
                        int newy=pop[1]+ys[j];
                        if (newx>=0&&newx<image.length&&newy>=0&&newy<image[0].length&&image[newx][newy]==pre&&mark[newx][newy]==0){
                            image[newx][newy]=color;
                            queue.add(new int[]{newx,newy});
                            mark[newx][newy]=1;
                        }

                    }
                }
            }
            return image;
        }
        int[] xs=new int[]{-1,1,0,0};
        int[] ys=new int[]{0,0,-1,1};
    }
}
