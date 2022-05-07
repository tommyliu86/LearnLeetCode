package com.lwf.learn.everyday.coding;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 14:17
 */
public class NearestValidPoint {

    class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int min=-1;
            int index=-1;
            for (int i = 0; i < points.length; i++) {
                if (points[i][0]==x||points[i][1]==y) {
                    int dis=Math.abs (points[i][0]-x)+Math.abs(points[i][1]-y);
                    if (min==-1|| min>dis){
                        min=dis;
                        index=i;
                    }
                }
            }
            return index;
        }
    }
}
