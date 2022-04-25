package com.lwf.arithmetic.level2.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-23 19:09
 */
public class ThreeSum {
    class Solution {
        /**
         * 迭代
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rtn = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (left != i + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        rtn.add(list);
                        left++;
                        right--;
                    } else {
                        left++;
                    }
                }

            }
            return rtn;
        }

    }

    class dfs {
        /**
         * 递归
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rtn = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                recursive(nums, i, left, right, rtn);
            }
            return rtn;
        }

        public void recursive(int[] nums, int i, int left, int right, List<List<Integer>> rtn) {
            if (left >= right) {
                return;
            }
            if (left != i + 1 && nums[left] == nums[left - 1]) {
                recursive(nums, i, left + 1, right, rtn);
            }else if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                recursive(nums, i, left , right-1, rtn);
            } else if (nums[i] + nums[left] + nums[right] > 0) {
                recursive(nums, i, left, right - 1, rtn);
            } else if (nums[i] + nums[left] + nums[right] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[left]);
                list.add(nums[right]);
                rtn.add(list);
                recursive(nums, i, left + 1, right - 1, rtn);
            } else {
                recursive(nums, i, left + 1, right, rtn);
            }
        }
    }
}

