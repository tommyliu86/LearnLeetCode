package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 826. 安排工作以达到最大收益
 *
 * @author: liuwenfei
 * @date: 2024/5/21-9:01
 */
public class MaxProfitAssignment {
    /**
     * 排序+二分查找，我们需要找到<=diff 的最大收益值。因此我们排序diff，然后从小到大遍历，找到每个diff下的最大收益
     * 然后遍历worker的diff，进行二分查找
     */
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            Integer[] indez = new Integer[difficulty.length];
            for (int i = 0; i < indez.length; i++) {
                indez[i] = i;
            }
            Arrays.sort(indez, (a, b) -> Integer.compare(difficulty[a], difficulty[b]));
            int[] scores = new int[difficulty.length];
            int s = 0;
            for (int i = 0; i < scores.length; i++) {
                scores[i] = (s = Math.max(s, profit[indez[i]]));
            }

            int ans = 0;
            for (int w : worker) {
                int i = 0, j = indez.length ;
                while (i < j) {
                    int m = (i + j) / 2;
                    //找第一个大于w的值
                    if (difficulty[indez[m]] <= w) {
                        i=m+1;
                    } else {
                        j=m;
                    }
                }
                if (i!=0){
                    ans+=scores[i-1];
                }
            }
            return ans;
        }
    }
}
