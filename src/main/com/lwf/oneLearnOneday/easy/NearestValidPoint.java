package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2022/12/1 9:09
 */
public class NearestValidPoint {
    class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
           int i=-1;
           int dis=Integer.MAX_VALUE;
            for (int j = 0; j < points.length; j++) {
                int[] point = points[j];
                if (point[0]==x||point[1]==y) {
                    int ai = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                    if (ai<dis){
                        i=j;
                        dis=ai;
                    }
                }
            }
            return i;
        }
    }
    class Solution1 {
        public int nearestValidPoint(int x, int y, int[][] points) {
            Integer[] indexex=new Integer[points.length];
            for (int i = 0; i < indexex.length; i++) {
                indexex[i]=i;
            }
            Arrays.sort(indexex,(a,b)->{
                int ai = Math.abs(points[a][0] - x) + Math.abs(points[a][1] - y);
                int bi = Math.abs(points[b][0] - x) + Math.abs(points[b][1] - y);
                if (ai==bi){
                    return Integer.compare(points[a][0]+points[a][1],points[b][0]+points[b][1]);
                }else{
                    return Integer.compare(ai,bi);
                }
            });
            return indexex[0];
        }
    }
}
