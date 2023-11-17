package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * 2656. K 个元素的最大和
 * @author liuwenfei
 * @date 2023/11/15 8:42
 */
public class MaximizeSum {
    class Solution {
        public int maximizeSum(int[] nums, int k) {
            int max= Arrays.stream(nums).max().getAsInt();
            return k*(max+max+k-1)/2;
        }
    }
}
