package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2024/1/19 8:53
 */
public class MinimumTime2809 {

    /**
     * 每个对应的i都会跟着时间变大nums2，考虑 第i次，整体为  sum（num1）+i*sum（num2），可以减少的是多少？
     * 我们可以移除i个，这i个操作，我们可以使用dp记录，每次的操作时的值来进行。。

     */
    class Solution {
        public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
            int n = nums1.size();
            int[][] dp=new int[n+1][n];
            int sum1=0,sum2=0;

            for (int i = 0; i < n; i++) {
                sum1+=nums1.get(i);
                sum2+=nums2.get(i);
                dp[0][i]=nums1.get(i);
            }

            for (int i = 1; i <= n; i++) {
                if (sum1+sum2*i - Arrays.stream(dp[i - 1]).max().getAsInt()<=x) {
                    return i;
                }

            }
            return -1;
        }
    }
}
