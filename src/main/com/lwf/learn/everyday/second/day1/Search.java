package com.lwf.learn.everyday.second.day1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-14 10:59
 */
public class Search {
    /**
     * 先二分找到 k ，分别在 0-k  k-n中二分
     */
    class test {
        public int search(int[] nums, int target) {
            if (nums[0] <= nums[nums.length - 1]) {
                return half(nums, target, 0, nums.length - 1);
            }
            int k = index(nums, 0, nums.length - 1);
            if (nums[nums.length - 1] < target) {
                return half(nums, target, 0, k);
            } else {
                return half(nums, target, k + 1, nums.length - 1);
            }

        }

        /**
         * 二分查找。当可能不存在时，需要left>right left==right两种情况分别进行判断。
         * @param nums
         * @param target
         * @param left
         * @param right
         * @return
         */
        private int half(int[] nums, int target, int left, int right) {
            if (left>right){
                return -1;
            }
            if (left == right) {
                return nums[right] == target ? right : -1;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return half(nums, target, left, mid - 1);
            } else {
                return half(nums, target, mid + 1, right);
            }

        }

        /**
         * 使用包含mid的递归，最终会找到最大的数的index。
         * @param nums
         * @param left
         * @param right
         * @return
         */
        private int index(int[] nums, int left, int right) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid]) {
                return index(nums, mid, right);
            }
            if (nums[mid] < nums[right]) {
                return index(nums, left, mid );
            }
            return left;
        }
    }

    /**
     * 没有上下边界，无法分开查找。
     */
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            if (nums[left] > target && nums[right] < target) {
                return -1;
            }
            while (nums[left] > target) {
                left = (left + right) / 2;
            }
            while (nums[right] < target) {
                right = (left + right) / 2;
            }

            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;

        }
    }
}
