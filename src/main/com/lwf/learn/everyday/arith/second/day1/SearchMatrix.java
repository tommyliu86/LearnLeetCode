package com.lwf.learn.everyday.arith.second.day1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-14 13:53
 */
public class SearchMatrix {
    /**
     * matrix 是有序的，因此可以直接二分。把二维下标转换为一维下标即可
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int length = matrix[0].length;
            return searchMatrix(matrix, length, target, 0, matrix.length*length-1);
        }

        private boolean searchMatrix(int[][] matrix, int length, int target, int left, int right) {

            if (left > right) {
                return false;
            }
            if (left == right) {
                int[] index = getIndex(left, length);
                return matrix[index[0]][index[1]] == target;
            }

            int midI = (left + right) / 2;
            int[] mid = getIndex(midI, length);
            if (matrix[mid[0]][mid[1]] == target) {
                return true;
            } else if (matrix[mid[0]][mid[1]] > target) {
                return searchMatrix(matrix,length, target,left,midI-1);
            } else {
                return searchMatrix(matrix,length, target, midI+1, right);
            }
        }

        private int[] getIndex(int i, int length) {
            int[] mid = new int[2];
            mid[0] = i / length;
            mid[1] = i % length;
            return mid;
        }
    }
}
