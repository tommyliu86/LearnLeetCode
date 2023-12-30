package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 10:20
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            int ans=0;
            if (prices.length==0){
                return ans;
            }
            int min=prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (min>prices[i]){
                    min=prices[i];
                }else{
                    ans=Math.max(ans, prices[i]-min);
                }
            }
            return ans;
        }
    }
}
