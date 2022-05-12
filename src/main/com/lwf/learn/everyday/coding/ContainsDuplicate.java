package com.lwf.learn.everyday.coding;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-12 11:03
 */
public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i]==nums[i-1]){
                    return true;
                }
            }
            return false;
        }
    }
}
