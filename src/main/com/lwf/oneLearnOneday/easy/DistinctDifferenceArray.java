package com.lwf.oneLearnOneday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2670. 找出不同元素数目差数组
 * @author liuwenfei
 * @date 2024/1/31 9:16
 */
public class DistinctDifferenceArray {
    /**
     * 从前和后遍历，计算差值
     */
    class Solution {
        public int[] distinctDifferenceArray(int[] nums) {
            int n = nums.length;
            int[] counts=new int[n];


            Set<Integer> sets=new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                sets.add(nums[i]);
                counts[i]=sets.size();
            }
            sets=new HashSet<>();
            for (int i = counts.length - 1; i >= 0; i--) {
                counts[i]-=sets.size();
                sets.add(nums[i]);
            }
            return counts;
        }
    }
}
