package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 11:32
 */
public class MaxProfit2 {
    class Solution {
        public int maxProfit(int[] prices) {
            int[] have=new int[prices.length];
            int[] nohave=new int[prices.length];
            have[0]=prices[0]*-1;

            for (int i = 1; i < prices.length; i++) {
                have[i]=Math.max(have[i-1],nohave[i-1]-prices[i]);
                nohave[i]=Math.max(nohave[i-1],have[i-1]+prices[i]);
            }
            return nohave[prices.length-1];
        }
    }
}
