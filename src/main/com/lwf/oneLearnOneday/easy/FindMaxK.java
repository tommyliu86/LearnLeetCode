package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/5/15 15:00
 */
public class FindMaxK {
    class Solution {
        public int findMaxK(int[] nums) {
            Arrays.sort(nums);
            int i=0,j=nums.length-1;
            if (nums[j]<0||nums[i]>0){
                return -1;
            }
            while (i<j){
                if (nums[j]+nums[i]==0){
                    return nums[j];
                }else if (nums[j]+nums[i]>0){
                    j--;
                }else{
                    i++;
                }
            }
            return -1;
        }
    }
}
