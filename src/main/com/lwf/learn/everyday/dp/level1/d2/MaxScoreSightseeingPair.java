package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 10:43
 */
public class MaxScoreSightseeingPair {
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int sum=0;
            int rtn=0;
            for (int i = 1; i < values.length; i++) {
                sum=Math.max(sum+values[i]-values[i-1]-1,values[i-1]+values[i]-1);
                rtn=Math.max(sum,rtn);
            }
            return rtn;
        }
    }
}
