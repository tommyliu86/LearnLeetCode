package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 16:19
 */
public class SearchMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int x=matrix.length-1;
            int y=0;
            while (x>=0&&y<matrix[0].length){
                if (matrix[x][y]>target) {
                    x--;
                }else if (matrix[x][y]<target){
                    y++;
                }else{
                    return true;
                }
            }
            return false;
        }
    }
}
