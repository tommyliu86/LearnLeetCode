package com.lwf.learn.everyday.arith.first.day1;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/search-insert-position/
 * 35. 搜索插入位置
 * @author: liuwenfei14
 * @date: 2022-04-01 09:17
 */
public class SearchInsert {
    class Solution {
        public int searchInsert(int[] nums, int target) {
         int left=0;
         int right=nums.length-1;
         while (left<=right){
             int mid=left+(right-left)/2;
             if (nums[mid]==target){
                 return mid;
             }else if (nums[mid]>target){
                 right=mid-1;
             }else{
                 left=mid+1;
             }
         }
         return left;
        }

    }
}
