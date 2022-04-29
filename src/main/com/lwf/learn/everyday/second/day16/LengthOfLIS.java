package com.lwf.learn.everyday.second.day16;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-28 10:09
 */
public class LengthOfLIS {
    /**
     * 动态规划的变化
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {

            int count = 0;
            int[] l = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    l[count] = nums[i];
                    count++;
                } else {
                    int half = half(l, 0, count - 1, nums[i]);
                    if (l[half] >= nums[i]) {
                        l[half] = nums[i];
                    } else {
                        l[half + 1] = nums[i];
                        if (half + 1 == count) {
                            count++;
                        }
                    }
                }
            }
            return count;

        }

        public int half(int[] l, int left, int right, int t) {
            if (left >= right) {
                return left;
            }
            int mid = (left + right) / 2;
            if (l[mid] == t) {
                return mid;
            } else if (l[mid] > t) {
                return half(l, left, mid - 1, t);
            } else {
                return half(l, mid + 1, right, t);
            }

        }
    }

}
