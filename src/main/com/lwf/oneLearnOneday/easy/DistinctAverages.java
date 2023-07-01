package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctAverages {
    class Solution {
        public int distinctAverages(int[] nums) {
            Arrays.sort(nums);
            Set<Double > set=new HashSet<>();
            for (int i = 0; i < nums.length/2; i++) {
                set.add((double)(nums[nums.length-1-i]+nums[i])/2);
            }
            return set.size();
        }

    }
}
