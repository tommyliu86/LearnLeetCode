package com.lwf;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-09-02-22:42
 */
public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] > 0) {
            if (nums[0] >= 0) {

                return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
            } else {
                return nums[nums.length - 1] * Math.max(nums[nums.length - 2] * nums[nums.length - 3], nums[0] * nums[1]);
            }
        } else if (nums[nums.length - 1] == 0) {
            return 0;
        } else {
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }

    }

}
