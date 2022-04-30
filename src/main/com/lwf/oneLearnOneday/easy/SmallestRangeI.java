package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-30 09:49
 */
public class SmallestRangeI {
    class Solution {
        public int smallestRangeI(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-1]-nums[0]>2*k?(nums[nums.length-1]-nums[0]-2*k):0;
        }
    }
}
