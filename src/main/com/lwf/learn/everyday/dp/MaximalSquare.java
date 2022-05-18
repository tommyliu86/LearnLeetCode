package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-17 10:41
 */
public class MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int max =0;
            int[][] len=new int[matrix.length][matrix[0].length];

            for (int i = 0; i < len.length; i++) {
                len[i][0]=matrix[i][0]-'0';
                if (len[i][0]==1){
                    max=1;
                }
            }
            for (int i = 0; i < len[0].length; i++) {
                len[0][i]=matrix[0][i]-'0';
                if (len[0][1]==1){
                    max=1;
                }
            }

            for (int i = 1; i < len.length; i++) {
                for (int j = 1; j < len[i].length; j++) {
                    if (matrix[i][j]=='1'){
                        len[i][j]=Math.min( Math.min(len[i-1][j-1],len[i-1][j]),len[i][j-1])+1;
                        max=Math.max(len[i][j],max);
                    }else {
                        len[i][j]=0;
                    }
                }
            }
            return max;
        }
    }
}
