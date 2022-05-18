package com.lwf.learn.everyday.coding.level1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 14:33
 */
public class ArraySign {
    class test {
        public int arraySign(int[] nums) {
            int rtn=1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==0) {
                    return 0;
                }
                rtn*=nums[i]>0?1:-1;
            }
            return rtn;
        }

    }

    class Solution {
        public int arraySign(int[] nums) {
            Arrays.sort(nums);
            int i = find(nums, 0, nums.length - 1);
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] > 0) {
                if (i == 0) {
                    return 1;
                } else {
                    return (i & 1) == 1 ? -1 : 1;
                }
            } else {
                return ((i + 1) & 1) == 1 ? -1 : 1;
            }
        }

        public int find(int[] nums, int left, int right) {
            if (left >= right) {
                return left;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == 0) {
                return mid;
            } else if (nums[mid] > 0) {
                return find(nums, left, mid - 1);
            } else {
                return find(nums, mid + 1, right);
            }
        }
    }
}
