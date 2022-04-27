package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-26 09:18
 */
public class ProjectionArea {
    class Solution {
        public int projectionArea(int[][] grid) {
            int[] x=new int[grid.length];
            int[] y=new int[grid[0].length];
            int sum=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int cur = grid[i][j];
                    if (cur==0){
                        sum--;
                    }
                    if (cur>x[i]){
                        x[i]=cur;
                    }
                    if (cur>y[j]){
                        y[j]=cur;
                    }
                }
            }
            sum += grid.length * grid[0].length;
            for (int i = 0; i < x.length; i++) {
                sum+=x[i];
            }
            for (int i = 0; i < y.length; i++) {
                sum+=y[i];
            }
            return sum;
        }
    }
}
