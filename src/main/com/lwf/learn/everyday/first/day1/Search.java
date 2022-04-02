package com.lwf.learn.everyday.first.day1;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * https://leetcode-cn.com/problems/binary-search/
 * 704. 二分查找
 *
 * @author: liuwenfei14
 * @date: 2022-03-31 19:24
 */
public class Search {
    class Solution {
        public int search(int[] nums, int target) {
            return halfSearch(nums,0,nums.length-1,target);
        }

        public int halfSearch(int[] nums, int left, int right, int target) {
            if (left >= right) {
                return nums[left] == target ? left : -1;
            }
            int halfIndex = (right + left) / 2;
            if (nums[halfIndex]==target){
                return halfIndex;
            }if (nums[ halfIndex]>target){
                return halfSearch(nums,left,halfIndex-1,target);
            }else{
                return halfSearch(nums,halfIndex+1,right,target);
            }


        }
    }
}
