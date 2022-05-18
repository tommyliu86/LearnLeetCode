package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 13:21
 */
public class MaxProfit4 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int have=-prices[0];
            int nohave=0;
            for (int i = 0; i < prices.length; i++) {
                nohave=Math.max(nohave,have+prices[i]-fee);
                have=Math.max(have,nohave-prices[i]);
            }
            return nohave;
        }
    }
}
