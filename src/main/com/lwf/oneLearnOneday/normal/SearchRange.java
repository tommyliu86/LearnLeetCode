package com.lwf.oneLearnOneday.normal;

/**
 * author Administrator
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * time 2019-09-27-23:21
 * {@link 34.md}
 */
public class SearchRange {
    public static void main(String[] args) {
        System.out.println(new com.lwf.TOP100.normal.SearchRange().searchRange(new int[]{1, 2, 3}, 2));
        System.out.println("hello world");
    }

    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    int[] binarySearch(int[] nums, int left, int right, int target) {
        if (left >= right) {
            if (nums[left] == target) {
                return getInts(nums, left, target);
            } else {
                return new int[]{-1, -1};
            }
        } else {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return getInts(nums, mid, target);
            } else if (nums[mid] > target) {
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right, target);
            }

        }
    }

    private int[] getInts(int[] nums, int left, int target) {
        int[] rtn = new int[2];
        while (nums[--left] == target) {

        }
        rtn[0] = ++left;
        while (nums[++left] == target) {

        }
        rtn[1] = --left;
        return rtn;
    }
}
