package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/4/25 9:09
 */
public class MinHeightShelves {
    class Solution {
        public int minHeightShelves(int[][] books, int shelfWidth) {
            //每个i表示前i个的最小高度
            int[] dp=new int[books.length+1];
            for (int i = 1; i < dp.length; i++) {
                dp[i]=dp[i-1]+books[i-1][1];
                int j=i-1;
                int wi=books[i-1][0];
                int max=books[i-1][1];
                //迭代最后一层的宽度情况，dp+最后一层的高度即可，dp保证了前i个的最佳
                while (j>0&& (wi+=books[--j][0])<=shelfWidth){
                    max=Math.max(max,books[j][1]);
                    dp[i]=Math.min(dp[i],dp[j]+max);
                }
            }
            return  dp[books.length];
        }
    }
}
