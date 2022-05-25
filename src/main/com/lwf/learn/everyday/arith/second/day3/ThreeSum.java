package com.lwf.learn.everyday.arith.second.day3;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-15 20:12
 */
public class ThreeSum {
    /**
     * 固定1个数，双指针找剩余两个
     */
    class doublePoint {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rtn = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -1 * nums[i];
                List list = getTarget(nums, i + 1, nums.length - 1, target);
                if (!list.isEmpty()) {
                    rtn.add(list);
                }
            }
            return rtn;
        }

        List<List<Integer>> getTarget(int[] nums, int left, int right, int target) {
            List<List<Integer>> list = new ArrayList<>();
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] == target) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[left]);
                    l.add(nums[right]);
                    l.add(target * -1);
                    list.add(l);
                    while ((++left <right && nums[left] == nums[left-1])) {
                    }
                   while ((--right  >left && nums[right] == nums[right +1])) {

                    }
                } else {
                    left++;
                }
            }
            return list;
        }
    }

    /**
     * 固定两个数，查找剩下一个，需要使用双重循环+一个logn
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> rtn = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {

                for (int j = i + 1; j < nums.length - 1; j++) {

                    int target = -1 * (nums[i] + nums[j]);
                    if (getTarget(nums, j + 1, nums.length - 1, target)) {
                        rtn.add(Arrays.asList(nums[i], nums[j], target));
                    }
                }
            }
            return new ArrayList<>(rtn);
        }

        boolean getTarget(int[] nums, int left, int right, int target) {
            if (target > nums[right] || target < nums[left]) {
                return false;
            }
            if (left >= right) {
                return nums[left] == target;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                return getTarget(nums, mid + 1, right, target);
            } else {
                return getTarget(nums, left, mid - 1, target);
            }
        }
    }
}
