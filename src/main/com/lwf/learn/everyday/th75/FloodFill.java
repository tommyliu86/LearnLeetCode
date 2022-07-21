package com.lwf.learn.everyday.th75;

public class FloodFill {
    /**
     * 深度遍历
     */
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc]==color){
                return image;
            }
            int old=image[sr][sc];
            image[sr][sc]=color;
            for (int i = 0; i < step.length; i++) {
                int nx=sr+step[i][0];
                int ny=sr+step[i][1];
                if (nx>=0&&nx<image.length&&ny>=0&&ny<image[0].length&&image[nx][ny]==old){
                    floodFill(image,nx,ny,color);
                }
            }
            return image;
        }
        int[][] step=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    }
}
