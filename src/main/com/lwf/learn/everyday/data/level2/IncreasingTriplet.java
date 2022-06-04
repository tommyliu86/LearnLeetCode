package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 17:09
 */
public class IncreasingTriplet {
    class Solution {
        public boolean increasingTriplet(int[] nums) {

            int pre = nums[0];
            int cur = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > cur) {
                    return true;
                }
                if (nums[i] < cur) {
                    if (nums[i] > pre) {
                        cur = nums[i];
                    }
                    if (nums[i] < pre) {
                        pre = nums[i];
                    }
                }
            }
            return false;
        }
    }
}
