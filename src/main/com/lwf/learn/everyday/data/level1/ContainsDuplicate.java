package com.lwf.learn.everyday.data.level1;

import java.util.Arrays;

public class ContainsDuplicate {
        class Solution {
            public boolean containsDuplicate(int[] nums) {
                Arrays.sort(nums);
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i]==nums[i-1]) {
                        return true;
                    }
                }
                return false;
            }
        }
}
