package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-24 14:39
 */
public class MinCostClimbingStairs {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] min=new int[cost.length+1];
            for (int i = 2; i < min.length; i++) {
                min[i]=Math.min(min[i-2]+cost[i-2],min[i-1]+cost[i-1]);
            }
            return min[cost.length];

        }
    }
}
