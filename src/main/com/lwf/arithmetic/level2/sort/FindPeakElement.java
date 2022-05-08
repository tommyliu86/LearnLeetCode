package com.lwf.arithmetic.level2.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 17:13
 */
public class FindPeakElement {
    class Solution {
        public int findPeakElement(int[] nums) {
            return half(nums,0,nums.length-1);
        }
        public int half(int[] nums,int left,int right){
            if (left>=right){
                return left;
            }
            int mid=(left+right)/2;
            if (nums[mid]>nums[mid+1]){
              return half(nums,left,mid);
            }else{
                return half(nums,mid,right);
            }
        }
    }
}
