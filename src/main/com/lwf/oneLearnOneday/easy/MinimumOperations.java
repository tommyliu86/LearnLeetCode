package com.lwf.oneLearnOneday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/2/24 9:31
 */
public class MinimumOperations {
    /**
     * hash存储
     */
    class Solution {
        public int minimumOperations(int[] nums) {
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            return set.size()-(set.contains(0)?1:0);
        }
    }
}
