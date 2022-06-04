package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 12:02
 */
public class MaxProfit4 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int have=-prices[0];
            int nohave=0;

            for (int i = 1; i < prices.length; i++) {
                have=Math.max(nohave-prices[i],have);
                nohave=Math.max(have+prices[i]-fee,nohave);
            }
            return nohave;
        }
    }
}
