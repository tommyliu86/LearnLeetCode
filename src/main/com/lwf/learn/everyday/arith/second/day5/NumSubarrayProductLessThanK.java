package com.lwf.learn.everyday.arith.second.day5;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-17 11:39
 */
public class NumSubarrayProductLessThanK {
    /**
     * 巧算计数,对于 left ->right，每个right固定时，从left到right的子数组个数是 right-left+1个，
     * 因此，设置left=0，从前向后计算multi，对于每个right，当前表示的是left-》right的乘数，若小于target
     * 则表示从left到right的所有子数组都符合要求，当multi>target时，需要移动left向前，直到multi<target之后
     * 再进行记录子数组！
     */
    class test {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int count = 0;
            long multi = 1;
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                multi *= nums[i];
                while (left<=i&& multi >= k) {
                    multi /= nums[left++];
                }


                if (multi < k) {
                    count += (i - left + 1);
                }
            }
            return count;
        }
    }

        /**
         * 暴力法，直接遍历数组的所有子数组
         */
        class Solution {
            public int numSubarrayProductLessThanK(int[] nums, int k) {
                int count = 0;
                for (int i = 0; i < nums.length; i++) {
                    long multi = 1;
                    for (int j = i; j < nums.length; j++) {
                        multi *= nums[j];
                        if (multi < k) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
                return count;
            }
        }
    }
