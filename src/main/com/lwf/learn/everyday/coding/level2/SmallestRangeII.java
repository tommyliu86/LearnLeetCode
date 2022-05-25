package com.lwf.learn.everyday.coding.level2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *  把每个i当做 + 和-的分隔点，这样就可以把一个递增序列分成两个递增序列， 这样就变成了比较两个递增序列的问题！
 * @author: liuwenfei14
 * @date: 2022-05-25 14:17
 */
public class SmallestRangeII {
    class Solution {
        public int smallestRangeII(int[] nums, int k) {
            Arrays.sort(nums);

            int min = nums[0];
            int max = nums[nums.length - 1];
            int rtn = max - min;
            for (int i = 0; i < nums.length - 1; i++) {
                int cur = nums[i] + k;
                int post = nums[i + 1] - k;

                int low = Math.min(min + k, post);
                int high = Math.max(max - k, cur);
                rtn = Math.min(high-low, rtn);
            }
            return rtn;
        }
    }
}
