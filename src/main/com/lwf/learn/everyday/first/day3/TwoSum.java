package com.lwf.learn.everyday.first.day3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-02 11:14
 */
public class TwoSum {
    /**
     * 双指针，left +right的值和target进行比较，大则right--，小则left++
     */
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            boolean find = false;
            while (!find && left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    find = true;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }

            return new int[]{left+1, right+1};
        }
    }
}
