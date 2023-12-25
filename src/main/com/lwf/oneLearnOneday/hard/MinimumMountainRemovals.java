package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 1671. 得到山形数组的最少删除次数
 *
 * @author liuwenfei
 * @date 2023/12/22 17:39
 */
public class MinimumMountainRemovals {
    /**
     * 不能用单调栈，要用dp，找到每个点的左边最大和右边最大
     * 一个点位置上，分为，选择这个点的最长，和不选这个点的最长，不选当前点，则是max(i-1),选这个点=1+（maxLong(floor（i)))
     * 如何找单调递增序列，可以使用长度为下标的单调序列，
     */
    class Solution {
        public int minimumMountainRemovals(int[] nums) {
            int n = nums.length;
            int[] countPre = new int[n];
            int[] countPost = new int[n];

            //dp找到每个点的最长。
            List<Integer> dp = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                int preL = half(dp, cur);
                countPre[i] = preL + 1;
                if (dp.size() == preL ) {
                    dp.add(cur);
                } else {
                    dp.set(preL, cur);
                }
            }
            //dp找到每个点的最长。
            dp = new ArrayList<>();

            for (int i = n - 1; i >= 0; i--) {

                int cur = nums[i];
                int preL = half(dp, cur);
                countPost[i] = preL+1;
                if (dp.size() == preL ) {
                    dp.add(cur);
                } else {
                    dp.set(preL, cur);
                }
            }
            int ans = n;
            for (int i = 1; i < countPre.length - 1; i++) {
                if (countPre[i]>1&&countPost[i]>1){
                    ans = Math.min(ans, n - countPre[i]-countPost[i]+1);
                }
            }
            return ans;

        }

        //获取小于cur的长度
        private int half(List<Integer> dp, int cur) {
            if (dp.size() == 0 || cur < dp.get(0)) {
                return 0;
            }
            if (cur > dp.get(dp.size() - 1)) {
                return dp.size();
            }
            int i = 0, j = dp.size() - 1;
            //找到第一个大于等于cur的，因此这个index就是小于cur的长度
            while (i < j) {
                int m = i + (j - i) / 2;
                if (dp.get(m) >= cur) {
                    j = m;
                } else {
                    i = m + 1;
                }
            }
            return i;
        }
    }
}
