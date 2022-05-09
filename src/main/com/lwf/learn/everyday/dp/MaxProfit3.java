package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 * have(i)=nohave(i-2)- pi,have(i-1);
 * nohave(i)=have(i-1)+pi,nohave(i-1)
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 10:32
 */
public class MaxProfit3 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }
            int[] have = new int[prices.length]; //i处表示 i处有持股 have(i-1),nohave(i-1)-price(i),
            int[] nohave = new int[prices.length]; //i处表示 非当日买出的无股票的最大，nohave(i-1),must（i-1);
            int[] must = new int[prices.length]; //i处表示必须是卖出。have(i-1)+price(i)
            have[0] = -prices[0];
            have[1] = Math.max(have[0], -prices[1]);
            must[1] = prices[1] + have[0];
            for (int i = 2; i < prices.length; i++) {
                have[i] = Math.max(have[i - 1], nohave[i - 1] - prices[i]);
                nohave[i] = Math.max(nohave[i - 1], must[i - 1]);
                must[i] = have[i - 1] + prices[i];
            }
            return Math.max(nohave[prices.length - 1], must[prices.length - 1]);
        }
    }
}
