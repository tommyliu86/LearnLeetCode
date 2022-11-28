package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/11/28 11:30
 */
public interface Check {
    class Solution {
        public boolean check(int[] nums) {
            int fIndex=1;
           while (fIndex<nums.length){
               if (nums[fIndex-1]>nums[fIndex]){
                   break;
               }
               fIndex++;
           }
           if (fIndex==nums.length){
               return true;
           }
           int i=fIndex+1;
           while (i<nums.length){
               if (nums[i]<nums[i-1]){
                   return false;
               }
               i++;
           }
           return nums[nums.length-1]<=nums[0];


        }
    }
}
