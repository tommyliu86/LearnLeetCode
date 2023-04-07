package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/4/4 18:11
 */
public class MergeStones {
    public static void main(String[] args) {
        new Solution().mergeStones(new int[]{3,2,4,1}
        ,2);
    }
    static
    class Solution {
        public int mergeStones(int[] stones, int k) {
            int l = stones.length;

            if (l<k||(l-k)%(k-1)!=0){
                return -1;
            }
            int[] sums=new int[l+1];
            for (int i = 1; i < sums.length; i++) {
                sums[i]=sums[i-1]+stones[i-1];
            }
            int[][] dp=new int[l][l];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i],Integer.MAX_VALUE);
                dp[i][i]=0;
            }

            int il=k-1;
            while (il<l){
                for (int i = 0; i +il< dp.length; i++) {
                    //i是起点， i+il 是终点
                    for (int j = i; j-(k-1) <= i; j++) {
                        dp[i][i+il]=Math.min(dp[i][i+il],sums[i+il+1]-sums[i]+dp[j][j+il-(k-1)] ) ;
                    }
                }
                il+=k-1;
            }
            return dp[0][l-1];
        }
    }
}
