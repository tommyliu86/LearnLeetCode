package com.lwf.arithmetic.level2.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 19:52
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(new Solution().index(new int[]{5, 6, 7, 8, 0, 1, 2}, 0, 7));
    }
    static class Solution {
        public int search(int[] nums, int target) {
            if (nums[0] > nums[nums.length - 1]) {
                int i = index(nums, 0, nums.length - 1);
                int left = half(nums, 0, i, target);
                if (nums[left] == target) {
                    return left;
                } else {
                    int right = half(nums, i + 1, nums.length - 1, target);
                    if (nums[right] == target) {
                        return right;
                    } else {
                        return -1;
                    }
                }
            } else {
                int half = half(nums, 0, nums.length - 1, target);
                if (nums[half] == target) {
                    return half;
                } else {
                    return -1;
                }
            }
        }

        /**
         * 找最大值，只能是用mid和同一个值（left or right）比较，不然可能会有mid=left or mid=right的情况，导致if不能全覆盖
         * @param nums
         * @param left
         * @param right
         * @return
         */
        public int index(int[] nums, int left, int right) {

            int mid = (left + right) / 2;
            if (nums[mid] < nums[left]) {
                return index(nums, left, mid);
            }
            if (nums[mid] > nums[left]) {
                return index(nums, mid, right);
            }
            return left;
        }

        public int half(int[] nums, int left, int right, int t) {
            if (left >= right) {
                return left;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == t) {
                return mid;
            } else if (nums[mid] > t) {
                return half(nums, left, mid - 1, t);
            } else {
                return half(nums, mid + 1, right, t);
            }
        }
    }
}
