package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 14:44
 */
public class MinCostClimbingStairs {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {

            int pre=cost[0];
            int cur=cost[1];
            int i=2;
            while (i<cost.length){
                int temp=cur;
                cur=cost[i]+ Math.min(pre,cur);
                pre=temp;
                i++;
            }
            return cur;
        }
    }
}
