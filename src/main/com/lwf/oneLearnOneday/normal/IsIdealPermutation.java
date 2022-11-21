package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/11/16 9:13
 */
public class IsIdealPermutation {
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            int n=nums.length;
            int min=nums[n-1];
            for (int i = n-3; i >= 0; i--) {
                if (nums[i]>min){
                    return false;
                }
                min=Math.min(min,nums[i+1]);
            }
            return true;
        }
    }
    class Solution1 {
        public boolean isIdealPermutation(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]>i){
                    if (nums[i]==i+1&&(i+1)<nums.length&&nums[i+1]==i){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
