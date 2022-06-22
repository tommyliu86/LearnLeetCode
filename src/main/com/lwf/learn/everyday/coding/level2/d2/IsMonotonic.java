package com.lwf.learn.everyday.coding.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 15:31
 */
public class IsMonotonic {
    class Solution {
        public boolean isMonotonic(int[] nums) {
            int upDown = 0;
            for (int i = 1; i < nums.length; i++) {
                int cur = 0;
                if (nums[i] > nums[i - 1]) {
                    cur = 1;
                }
                if (nums[i] < nums[i - 1]) {
                    cur = -1;
                }
                if (upDown == 0) {
                    upDown = cur;
                } else if (upDown + cur == 0) {
                    return false;
                }

            }
            return true;
        }
    }
}
