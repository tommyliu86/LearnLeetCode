package com.lwf.learn.everyday.second.day2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-15 15:14
 */
public class FindMin {
    /**
     * 二分法的灵活应用
     */
    class Solution {
        public int findMin(int[] nums) {
            if (nums[0]<=nums[nums.length-1]){
                return nums[0];
            }
            return findMin(nums,0,nums.length-1);
        }
        public int findMin(int[] nums ,int left,int right){
            if (left==right){
                return nums[right+1];
            }
            int mid=(left+right)/2;
            if (nums[left]<nums[mid]){
                return findMin(nums,mid,right);
            }else {
                return findMin(nums,left,mid);
            }
        }
    }
}
