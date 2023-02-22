package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/2/22 10:32
 */
public class StoneGame {
    /**
     * dp 逆向dp 从最后剩余来反推到开始的思路
     */
    class Solution {
        public boolean stoneGame(int[] piles) {
            //dp[i][j]=长度为i-j时，两个人的获取差值，使用差值可以不用计算总和，不然+1时，无法计算，
            int[][] dp=new int[piles.length][piles.length];
            for (int i = 0; i < dp.length; i++) {
                dp[i][i]=piles[i];
            }
            for (int l = 1; l < dp.length; l++) {
                for (int i = 0;i+l<dp.length&& i < dp.length; i++) {
                    //这段计算是，假设当前为奇数长度，则剩余的差值是自己的，用加，假设偶数长度，则剩余的是另外一个人的，则用减法
                    dp[i][i+l]= Math.max(dp[i+1][i+l]+(l%2==1?-1:1)*dp[i][i],dp[i][i+l-1]+(l%2==1?-1:1)*dp[i+l][i+l]);
                    // 当前拿了一个点，则后面的肯定是另外一个人的优势局，因此这时当前人能获取到的就是拿到的点--后面的部分
                    dp[i][i+l]= Math.max(dp[i][i]-dp[i+1][i+l],dp[i+l][i+l]-dp[i][i+l-1]);
                }

            }
            return dp[0][piles.length-1]>0;
        }
    }
}
