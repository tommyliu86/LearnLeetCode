package com.lwf.learn.everyday.first.day7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-06 11:54
 */
public class FloodFill {
    class dfs {
        /**
         * 深度优先遍历
         * @param image
         * @param sr
         * @param sc
         * @param newColor
         * @return
         */
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldC=image[sr][sc];
            if (oldC==newColor){
                return image;
            }
            dfs(image,sr,sc,image[sr][sc],newColor);
            return image;

        }
        private void dfs(int[][]image,int x,int y,int oldColor, int newColor){
            image[x][y]=newColor;
            if (x-1>=0&&image[x-1][y]==oldColor){
                dfs(image,x-1,y,oldColor,newColor);
            }
            if (x+1<image.length&&image[x+1][y]==oldColor){
                dfs(image,x+1,y,oldColor,newColor);
            }
            if (y-1>=0&&image[x][y-1]==oldColor){
                dfs(image,x,y-1,oldColor,newColor);
            }
            if (y+1<image[0].length&&image[x][y+1]==oldColor){
                dfs(image,x,y+1,oldColor,newColor);
            }
        }
    }

    /**
     * 广度优先遍历
     */
    class bfs {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

            int oldC=image[sr][sc];
            if (oldC==newColor){
                return image;
            }
            Queue<int[]> queue=new LinkedList<>();
            image[sr][sc]=newColor;
            ((LinkedList<int[]>) queue).add(new int[]{sr,sc});
            int xL=image.length;
            int rL=image[0].length;
            while (!queue.isEmpty()){
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                if (x-1>=0&&image[x-1][y]==oldC){
                    image[x-1][y]=newColor;
                    queue.add(new int[]{x-1,y});
                }
                if (x+1<xL&&image[x+1][y]==oldC){
                    image[x+1][y]=newColor;
                    queue.add(new int[]{x+1,y});
                }
                if (y-1>=0&&image[x][y-1]==oldC){
                    image[x][y-1]=newColor;
                    queue.add(new int[]{x,y-1});
                }
                if (y+1<rL&&image[x][y+1]==oldC){
                    image[x][y+1]=newColor;
                    queue.add(new int[]{x,y+1});
                }
            }
            return image;
        }
    }
}
