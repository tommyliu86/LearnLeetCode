package com.lwf.oneLearnOneday.easy;

/**
 * 746. 使用最小花费爬楼梯
 * @author liuwenfei
 * @date 2023/12/18 19:38
 */
public class MinCostClimbingStairs {
    /**
     * dp
     * 到达楼顶，是走到最后，cost.length-1是最后一节台阶
     */
    class Solution {
        public int minCostClimbingStairs(int[] cost) {

            for (int i = 2; i < cost.length; i++) {
                cost[i]+=Math.min( cost[i-1],cost[i-2]);
            }
            return Math.min( cost[cost.length-1],cost[cost.length-2]);
        }
    }
}
