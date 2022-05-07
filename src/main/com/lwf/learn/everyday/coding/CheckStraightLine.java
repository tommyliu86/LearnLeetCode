package com.lwf.learn.everyday.coding;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 16:08
 */
public class CheckStraightLine {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            int x=coordinates[0][0]-coordinates[1][0];
            int y=coordinates[0][1]-coordinates[1][1];
            for (int i = 2; i < coordinates.length; i++) {
               int nx=coordinates[i][0]-coordinates[0][0];
               int ny=coordinates[i][1]-coordinates[0][1];
               if (x*ny-y*nx!=0){
                   return false;
               }
            }
            return true;
        }
    }
}
