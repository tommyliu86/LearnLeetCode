package com.lwf.oneLearnOneday.easy;



/**
 * @author liuwenfei
 * @date 2023/8/11 8:45
 */
public class DiagonalSum {
    class Solution {
        public int diagonalSum(int[][] mat) {
            int ans=0;
            for (int i = 0; i < mat.length; i++) {
                ans+=mat[i][i];
                if (i!=mat.length-1-i) {

                ans+=mat[i][mat.length-1-i];
                }
            }
            return ans;
        }
    }
}
