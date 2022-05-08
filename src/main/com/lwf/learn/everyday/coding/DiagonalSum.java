package com.lwf.learn.everyday.coding;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-08 15:29
 */
public class DiagonalSum {
    class Solution {
        public int diagonalSum(int[][] mat) {
            int sum=0;
            int l = mat.length - 1;
            for (int i = 0; i < mat.length; i++) {
                sum+=mat[i][i];
                if (l-i!=i){

                    sum+=mat[l-i][i];
                }
            }
            return sum;
        }
    }
}
