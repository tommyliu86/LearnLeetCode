package com.lwf.oneLearnOneday.easy;

/**
 * 2760. 最长奇偶子数组
 * https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/?envType=daily-question&envId=2023-11-14
 *
 * @author liuwenfei
 * @date 2023/11/16 14:20
 */
public class LongestAlternatingSubarray {
    /**
     * 双指针遍历
     */
    class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int i = 0;
            int max = 0;
            while (i < nums.length) {
                if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                    int j = i + 1;
                    while (j < nums.length && nums[j] <= threshold && (nums[j] % 2) != (nums[j - 1] % 2)) {
                        j++;
                    }
                    max = Math.max(max, j - i);
                    i = j;
                } else {
                    i++;
                }
            }
            return max;
        }
    }
}
