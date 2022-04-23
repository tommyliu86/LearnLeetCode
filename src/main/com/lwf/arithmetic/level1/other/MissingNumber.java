package com.lwf.arithmetic.level1.other;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-22 17:35
 */
public class MissingNumber {
    class bit {
        public int missingNumber(int[] nums) {
            int c=0;
            for (int i = 0; i <= nums.length; i++) {
                c^=i;
            }
            for (int i = 0; i < nums.length; i++) {
                c^=nums[i];
            }
            return c;
        }
    }
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            if (nums[0]!=0){
                return 0;
            }
            if (nums[nums.length-1]==nums.length-1){
                return nums.length;
            }
            return half(nums, 0, nums.length);
        }
        public int half(int[] nums,int left,int right){
            if (left>=right){
                return nums [left]== left?left+1:left;
            }
            int mid=(left+right)/2;
            if (nums[mid]==mid){
                return half(nums,mid+1,right);
            }else{
                return half(nums,left,mid-1);
            }
        }
    }
}
