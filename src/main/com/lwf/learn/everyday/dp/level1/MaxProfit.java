package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-08 17:16
 */
public class MaxProfit {
    /**
     * dp 思路，每个位置都计算作为买卖点，并且保存最小花费的买入点。
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int have = Integer.MIN_VALUE;
            int ans = 0;
            for (int i = 0; i < prices.length; i++) {
                if (have + prices[i] > 0) {
                    ans = Math.max(have + prices[i], ans);
                }
                have = Math.max(-1 * prices[i], have);

            }
            return ans;
        }
    }
}
