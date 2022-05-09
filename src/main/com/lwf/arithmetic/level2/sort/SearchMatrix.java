package com.lwf.arithmetic.level2.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 13:35
 */
public class SearchMatrix {
    /**
     * 类似于二分法，x，y方向都是递增的，因此从左下或右上进行查找可以快速找到相应的行列查找。
     */
    class test {
        public boolean searchMatrix(int[][] matrix, int target) {
            int x=matrix.length-1;
            int y=0;
            while (x>=0&&y<=matrix[0].length-1){
                if (matrix[x][y]>target){
                    x--;
                }else if (matrix[x][y]==target){
                    return true;
                }else if (matrix[x][y]<target){
                    y++;
                }
            }
            return false;
        }
    }

    /**
     * 深度遍历
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int x = matrix.length - 1;
            int y = 0;
            int[][] mark = new int[matrix.length][matrix[0].length];
            return search(matrix, target, x, y, mark);


        }

        public boolean search(int[][] m, int t, int x, int y, int[][] mark) {
            if (x < 0 || x > m.length - 1 || y < 0 || y > m[0].length - 1 || mark[x][y] == 1) {
                return false;
            }
            if (m[x][y] == t) {
                return true;
            }
            mark[x][y] = 1;
            if (m[x][y] > t) {
                return search(m, t, x - 1, y, mark) || search(m, t, x, y - 1, mark);
            } else {
                return search(m, t, x + 1, y, mark) || search(m, t, x, y + 1, mark);
            }

        }
    }
}
