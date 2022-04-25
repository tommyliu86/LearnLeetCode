package com.lwf.data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-24 21:18
 */
public class HalfSearch {
    /**
     * 第一种：存在元素，则直接查找返回最后一个
     */
    public void half(int[] ints, int left, int right, int target) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        if (ints[mid] == target) {
            return;
        } else if (ints[mid] > target) {
            half(ints, left, mid - 1, target);
        } else {
            half(ints, mid + 1, right, target);
        }
    }

    public int searchInsert(int[] nums, int target) {
        int index = half1(nums, 0, nums.length - 1, target);
        if (nums[index] == target) {
            return index;
        } else if (nums[index] < target) {
            return index + 1;
        } else {
            return index;
        }
    }

    /**
     * 可能不存在元素，查找到的是是大于或等于或小于目标的，需要用最后位置和target进行比较。
     */
    public int half1(int[] ints, int left, int right, int target) {
        if (left >= right) { //大的数不会超过length，但是小的可以为-1，所以取大的数。
            return left;
        }
        int mid = (left + right) / 2; //mid==left
        if (ints[mid] == target) {
            return mid;
        }
        if (ints[mid] > target) {
            return half1(ints, left, mid - 1, target);
        } else {
            return half1(ints, mid + 1, right, target);
        }
    }

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) { //这里等于时候还进行了比较，让left==right的位置和目标进行比较
                int mid = left + (right - left) / 2;
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
