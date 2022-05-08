package com.lwf.arithmetic.level2.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 17:40
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,10};
        System.out.println( new Solution().half(nums,0,nums.length-1,9,false));
    }
   static class Solution {
       public int[] searchRange(int[] nums, int target) {
           if (nums.length == 0) {
               return new int[]{-1, -1};
           }
           int half = half(nums, 0, nums.length - 1, target);
           if (nums[half] == target) {
               int low = half(nums, 0, half, target, false);
               int high = half(nums, half, nums.length - 1, target, true);
               high = nums[high] == target ? high : high - 1;
               low = nums[low] == target ? low : low + 1;
               return new int[]{low, high};
           } else {
               return new int[]{-1, -1};
           }
       }

       public int half(int[] nums, int left, int right, int tar, boolean big) {
           if (left >= right) {
               return left;
           }
           int mid = (left + right) / 2;
           if (nums[mid] < tar || (big && nums[mid] <= tar)) {
               return half(nums, mid + 1, right, tar, big);
           } else {
               return half(nums, left, mid - 1, tar, big);
           }
       }

       public int half(int[] nums, int left, int right, int target) {
           if (left >= right) {
               return left;
           }
           int mid = (left + right) / 2;
           if (nums[mid] == target) {
               return mid;
           } else if (nums[mid] < target) {
               return half(nums, mid + 1, right, target);
           } else {
               return half(nums, left, mid - 1, target);
           }
       }
   }
}
