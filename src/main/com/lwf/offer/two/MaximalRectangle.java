package com.lwf.offer.two;

import sun.text.resources.th.FormatData_th;

public class MaximalRectangle {
    public static void main(String[] args) {
        new Solution().maximalRectangle(new char[][]{{'1','1'}});
    }
    static
    class Solution {
        public int maximalRectangle(String[] matrix) {
            if (matrix.length==0) return 0;
            int[][][] dp=new int[matrix.length+1][matrix[0].length()+1][2];
                int max=0;
            for (int i = 1; i < dp.length; i++) {
                String str = matrix[i-1];
                for (int j = 1; j < dp[i].length; j++) {
                    if (str.charAt(j-1)!='0') {
                       dp[i][j][0]=dp[i][j-1][0]+1;
                       dp[i][j][1]=dp[i-1][j][1]+1;
                       int minL=dp[i][j][0];
                        for (int k = 0; k < dp[i][j][1]; k++) {
                            minL=Math.min(minL,dp[i-k][j][0]);
                            int sq = (k + 1) * minL;
                            max=Math.max(sq,max);
                        }
                    }
                }
            }
            return max;
        }


        public int maximalRectangle(char[][] matrix) {
            if (matrix.length==0) return 0;
            int max=0;
            int[][] dp=new int[matrix.length+1][matrix[0].length+1];
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if (matrix[i-1][j-1]=='1'){

                        dp[i][j]=dp[i][j-1]+1;
                        int minL=dp[i][j];
                        int k=i;
                        while (k>=0&&dp[k][j]>0){
                            minL=Math.min(minL,dp[k][j]);
                            max=Math.max(max,minL*(i-k+1));
                            k--;
                        }
                    }
                }
            }
            return max;
        }
    }
}
