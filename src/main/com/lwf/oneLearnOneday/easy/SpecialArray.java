package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/9/12 18:57
 */
public class SpecialArray {
    /**
     * 降序排列+遍历找到index <nums[index]的位置
     */
    class Solution {
        public int specialArray(int[] nums) {
            Arrays.sort(nums);
            int l = nums.length;
           int i=l-1;
           while (i>=0&&nums[i]>=l-i){
               i--;
           }
           return i>=0?( l-i-1>nums[i]?l-i-1:-1):l;
        }
    }
}
