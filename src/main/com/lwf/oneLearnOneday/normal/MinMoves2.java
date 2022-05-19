package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-19 10:02
 */
public class MinMoves2 {
    class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int step=0;
            int s=nums[nums.length/2 -1];
            for (int i = 0; i < nums.length; i++) {
                step+=nums[i]>=s?( nums[i]-s):(s-nums[i]);
            }
            return step;
        }
    }
}
