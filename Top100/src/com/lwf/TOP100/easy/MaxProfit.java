package com.lwf.TOP100.easy;

import java.lang.management.ClassLoadingMXBean;
import java.util.Stack;

/**
 * author Administrator
 * time 2019-09-11-23:49
 * {@link 121.md}
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int max=0;
        int lmax= Integer.MIN_VALUE;
        for (int i = prices.length-1; i >=0 ; i--) {
            if (lmax<prices[i]){
                lmax=prices[i];
            }else{
                max=Math.max(max,lmax-prices[i]);
            }

        }
        return max;
    }
}
