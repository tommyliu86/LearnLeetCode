package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-12-13 Time: 09:38
 */
public class MaxProfit {
    /**
     * have 和unhave分别表示资金总量，是i节点时，手中有股票和无股票两个状态拥有的资金总量，因此计算的值是【i】+price/
     * 这样的算法。理解了题目，方程式就好理解了
     * 动态规划推导过程，简单的情况是每个节点只有一个值，向前进行推导就行。这个题目是每个节点两个状态，因此需要使用两个数组来保存不同情况的值
     * 更复杂的还会有N个状态值的情况！
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length<2) return 0;
        int[] have=new int[prices.length];
        int[] unhave=new int [prices.length];
        have[0]=-prices[0];
        have[1]=Math.max(-prices[1],-prices[0]);
        unhave[0]=0;
        unhave[1]=Math.max(0,have[0]+prices[1]);

        int max=Math.max(have[1],unhave[1]);
        for (int i = 2; i < prices.length; i++) {
            have[i]=Math.max(have[i-1],unhave[i-2]-prices[i]);
            unhave[i]=Math.max(unhave[i-1],have[i-1]+prices[i]);
            max=Math.max(max,Math.max(have[i],unhave[i]));
        }
        return max;
    }
}
