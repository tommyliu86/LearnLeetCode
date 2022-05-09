package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-08 17:41
 */
public class MaxProfit2 {
    /**
     * f(i)表示在i处买入，i+1如果价格高于i，则表示有收益，因此计算sum，如果小于i，则表示不应该在i买，换到i+1买入。
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int have=Integer.MIN_VALUE;
            int sum=0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i]+have>0){
                    sum+=prices[i]+have;
                    have= -1*prices[i];
                }else{

                    have=Math.max(-1*prices[i],have);
                }
            }
            return sum;
        }
    }
    /**
     * have(i)表示在i处有股票，nohave(i)表示在i处没有股票，则在i+1处可以卖出，也可以买入
     * nohave(i+1)=have(i)+(i),nohave(i)
     * have(i+1)=nohave(i)-(i),have(i)
     */
    class test {
        public int maxProfit(int[] prices) {
            int have=-prices[0];
            int nohave=0;
            for (int i = 1; i < prices.length; i++) {
                nohave=Math.max(have+prices[i],nohave);
                have=Math.max(nohave-prices[i],have);
            }
            return nohave;
        }
    }
}
