package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-05 08:57
 */
public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    }

    /**
     * 暴力双循环求解
     */
    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int multi = 1;
                for (int j = i; j < nums.length; j++) {
                    multi *= nums[j];
                    if (multi >= k) {
                        break;
                    }
                    count++;
                }
            }
            return count;
        }
    }

    static class test {
        /**
         * 滑动窗口，双指针,每次右指针移动一次，记录一次当前的元素个数，这样，乘积可以不用每次重新计算。
         *
         * @param nums
         * @param k
         * @return
         */
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int left = 0;
            int right = 0;
            int count = 0;
            int multi = 1;
            while (right < nums.length) {
                multi *= nums[right];

                while (left <= right && multi >= k) {
                    multi /= nums[left];
                    left++;
                }
                count += (right - left + 1);
                right++;
            }
            return count + right - left;
        }
    }
}
