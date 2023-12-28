package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 2735. 收集巧克力
 * @author liuwenfei
 * @date 2023/12/28 9:24
 */
public class MinCost {
    /**
     * 使用双重循环，计算每个i可以走到的位置，并且计算1~n步中的最小，进行返回。
     */
    class Solution {
        public long minCost(int[] nums, int x) {
            int n = nums.length;
            //每个类型的初始化时的成本
            int[] costs=new int[n];
            for (int i = 0; i < n; i++) {
                costs[i]=nums[i];
            }
            //求当前的成本
            long ans= Arrays.stream(costs).asLongStream().sum();

            for (int i = 1; i < n; i++) {
                //每个j都会向前走i步，这样就表示在当前范围内的所有的最小值是这个j能取到的
                for (int j = 0; j < n; j++) {
                    costs[j]=Math.min(costs[j], nums[(j+i)%n]);
                }
                ans=Math.min(ans,Arrays.stream(costs).asLongStream().sum()+ (long) x *i);
            }
            return ans;
        }
    }
}
