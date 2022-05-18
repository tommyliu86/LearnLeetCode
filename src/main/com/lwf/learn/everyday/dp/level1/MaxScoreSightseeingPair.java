package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-08 16:58
 */
public class MaxScoreSightseeingPair {
    /**
     * 找到dp状态转移方程，设f(k)是 0到k，且以k结尾的最大，则k+1处的最大是 values[k+1] -values[k]-1 和  k+1与k组成的组合的最大值。
     * 因此一次遍历求解，用max记录最大即可
     */
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int sum=values[0]+values[1]-1;
            int max=sum;
            for (int i = 2; i < values.length; i++) {
                sum=Math.max(sum+ values[i]-values[i-1]-1,values[i]+values[i-1]-1);
                max=Math.max(sum,max);
            }
            return max;
        }
    }
}
