package com.lwf.learn.everyday.dp.level1.d2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-12 10:30
 */
public class CombinationSum4 {
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] sums=new int[target+1];
            Arrays.sort(nums);
            for (int i = 1; i < sums.length; i++) {
                int s=i;
                for (int j = 0; j < nums.length; j++) {
                    if (s<nums[j]){
                        break;
                    }
                    sums[i]+=sums[s-nums[j]];
                }
            }
            return sums[target];
        }
    }
}
