package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/16 14:43
 */
public class FindNumberIn2DArray {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length==0){
                return false;
            }
            int x=matrix.length;
            int y=matrix[0].length;
            int i=x-1,j=0;
            while (i>=0&&j<y){
                if (matrix[i][j]>target){
                    i--;
                }else if (matrix[i][j]==target){
                    return true;
                }else {
                    j++;
                }
            }
            return false;
        }
    }
}
