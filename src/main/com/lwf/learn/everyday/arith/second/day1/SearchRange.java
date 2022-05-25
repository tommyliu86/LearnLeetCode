package com.lwf.learn.everyday.arith.second.day1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-14 09:20
 */
public class SearchRange {
    public static void main(String[] args) {
        new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10},
                8);
    }

    static class test {
        public int[] searchRange(int[] nums, int target) {

            int i = halfSearch(nums, target, 0, nums.length - 1);
            if (i == -1) {
                return new int[]{-1, -1};
            }
            int left = i;
            while (left >= 0 && nums[left] == target) {
                left--;
            }
            left++;
            int right = i;
            while (right < nums.length && nums[right] == target) {
                right++;
            }
            right--;
            return new int[]{left, right};
        }

        public int halfSearch(int[] nums, int target, int left, int right) {
            if (left>right){
                return -1;
            }
            if (left == right) {
                return nums[right] == target ? right : -1;
            }
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                return halfSearch(nums, target, left, mid - 1);
            } else if (nums[mid] < target) {
                return halfSearch(nums, target, mid + 1, right);
            } else {
                return mid;
            }
        }
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = searchLeft(nums, target, 0, nums.length - 1);
            int right = searchRight(nums, target, 0, nums.length - 1);

            if (left + 1 >= right) {
                return new int[]{-1, -1};

            } else {
                return new int[]{left, right};
            }
        }

        public int searchLeft(int[] nums, int target, int left, int right) {
            if (left >= right) { //left==right时，需要继续，来找到right-1，也就是mid-1.
                return right;
            }
            int mid = (left + right) / 2;
            if (nums[mid] >= target) { //等于时候也要变小，left是<target的第一个位置
                return searchLeft(nums, target, left, mid - 1);
            } else {
                return searchLeft(nums, target, mid + 1, right);
            }
        }

        public int searchRight(int[] nums, int target, int left, int right) {
            if (left > right) {
                return left;
            }
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                return searchRight(nums, target, left, mid - 1);
            } else { //mid<=target，继续
                return searchRight(nums, target, mid + 1, right);
            }
        }
    }
}
