package com.lwf.offer.one;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/1/31 19:10
 */
public class IsStraight {
    /**
     * 计数器
     */
    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int count=0;
            int i=nums.length-2;
            while (i>=0&&nums[i]!=0){
                if (nums[i+1]==nums[i]){
                    return  false;
                }
                count+=nums[i+1]-nums[i]-1;
                i--;
            }
            return count<=i+1;
        }
    }
}
