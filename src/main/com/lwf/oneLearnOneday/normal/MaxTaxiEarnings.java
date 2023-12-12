package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2008. 出租车的最大盈利
 * @author liuwenfei
 * @date 2023/12/8 9:31
 */
public class MaxTaxiEarnings {
    /**
     * 动态规划，
     *
     * 合并区间从开始排序即可，dp求解则需要end排序，因为到end进行结算的。
     */
    class Solution {
        public long maxTaxiEarnings(int n, int[][] rides) {
            Arrays.sort(rides, Comparator.comparing(a->a[1]));
            long[] max=new long[n+1];

            for (int i = 0; i < rides.length; i++) {
                int[] ride = rides[i];
                max[ ride[1]]=Math.max(find(ride[1],max,rides), find(ride[0],max,rides)+ride[1]-ride[0]+ride[2]);
            }
            return find(n,max,rides);
        }
        public long find(int i,long[] max,int[][] rides){
            for (int j = i; j >= 0; j--) {
                if (max[j]>0){
                    return max[j];
                }
            }
            return 0;
        }
    }
}
