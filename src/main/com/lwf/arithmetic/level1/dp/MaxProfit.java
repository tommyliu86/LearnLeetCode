package com.lwf.arithmetic.level1.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-17 14:52
 */
public class MaxProfit {
    /**
     * 动态规划
     * 用两个数组保存每天有和没有股票时的最大收益。向后推导,这个是可以多次买卖的答案！而不是一次买卖的解法
     */
    class dp {
        public int maxProfit(int[] prices) {
            int[] has=new int[prices.length];
            int[] nohas=new int[prices.length];
            has[0]=-prices[0];
            nohas[0]=0;
            for (int i = 1; i < prices.length; i++) {
                has[i]=Math.max(has[i-1], nohas[i-1]-prices[i]);
                nohas[i]=Math.max(nohas[i-1], has[i-1]+prices[i]);
            }
            return nohas[prices.length-1];
        }
    }
    /**
     * 双指针
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int max=0;
            int minus=0;
            for (int i = prices.length - 1; i >= 0; i--) {
                if (prices[i]>max){
                    max=prices[i];
                }else {

                    minus=Math.max(minus,  max-prices[i]);
                }
            }
            return minus;
        }
    }
}
