package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/2/10 13:47
 */
public class DicesProbability {
    public static void main(String[] args) {
        new Solution().dicesProbability(1);
    }
    static
    class Solution {
        public double[] dicesProbability(int n) {
            int[][] marks=new int[n][n*6+1];
            for (int i = 1; i <= 6; i++) {
                marks[0][i]=1;
            }
            int count=6;
            for (int i = 1; i < marks.length; i++) {
                int[] pre = marks[i - 1];
                int curC=0;
                for (int j = 1; j <= 6; j++) {
                    for (int k = i; k <= i * 6; k++) {
                        marks[i][j+k]+=pre[k];
                        curC+=pre[k];
                    }
                }
                count=curC;
            }
            double[] ans=new double[n*6-n+1];
            for (int i = 0; i < ans.length; i++) {
              ans[i]=  (double) marks[n-1][n+i]/count;
            }
            return ans;
        }
    }
}
