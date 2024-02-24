package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 2171. 拿出最少数目的魔法豆
 * @author liuwenfei
 * @date 2024/1/18 8:54
 */
public class MinimumRemoval {
    /**
     * 前缀和的应用，先排序，如果要移除，则移除数目少的比移除多的划算，如果我们考虑从某一个数开始不移除，则从这个数开始向后的所有数都不移除且都应该和
     * 这个数大小相同，因此我们可以直接先计算出每个位置的前缀和以及总和，然后遍历直接计算即可。
     */
    class Solution {
        public long minimumRemoval(int[] beans) {
            Arrays.sort( beans);
            long[] preSum=new long[beans.length+1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i]=preSum[i-1]+(long) beans[i-1];
            }
            long min=Long.MAX_VALUE;
            long sum=preSum[beans.length];
            for (int i = 0; i < beans.length; i++) {
                long removed= sum -(long) (beans.length-i)*beans[i];
                min=Math.min(min,removed);
            }
            return min;
        }
    }
}
