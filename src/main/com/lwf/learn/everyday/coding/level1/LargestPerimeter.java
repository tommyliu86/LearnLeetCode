package com.lwf.learn.everyday.coding.level1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 14:07
 */
public class LargestPerimeter {
    class Solution {
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 2; i--) {
                if (nums[i]<nums[i-1]+nums[i-2]){
                    return nums[i]+nums[i-1]+nums[i-2];
                }
            }
            return 0;
        }
    }
}
