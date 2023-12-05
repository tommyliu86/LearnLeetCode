package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 1423. 可获得的最大点数
 * @author liuwenfei
 * @date 2023/12/5 8:23
 */
public class MaxScore {
    /**
     * 前缀和 ，暴力解法，直接求出左右两边可以到达的最大范围的和，然后遍历所有的组合，
     * 题目也可以使用滑动窗口，这样避免了进行sum前缀和的计算，直接进行滑动即可。
     */
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            if (cardPoints.length==k){
                return Arrays.stream(cardPoints).sum();
            }
            int[] left=new int[k];
            left[0]=cardPoints[0];
            int[] right=new int[k];
            right[0]=cardPoints[cardPoints.length-1];
            for (int i = 1; i < k; i++) {
                left[i]=left[i-1]+cardPoints[i];
            }
            for (int i = 1; i < k; i++) {
                right[i]=right[i-1]+cardPoints[cardPoints.length-1-i];
            }
            int sum=Math.max(left[k-1],right[k-1]);

            for (int i = 0; i <k-1; i++) {
                sum=Math.max(sum,left[i]+right[k-2-i]);
            }
            return sum;

        }
    }
}
