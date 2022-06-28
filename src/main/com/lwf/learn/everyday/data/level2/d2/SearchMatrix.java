package com.lwf.learn.everyday.data.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 16:41
 */
public class SearchMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
           int x=0;
           int y=matrix[0].length-1;
           while (x<matrix.length&&y>=0){
               if (matrix[x][y]>target){
                   y--;
               }else if (matrix[x][y]==target){
                   return true;
               }else{
                   x++;
               }
           }
           return false;
        }
    }
}
