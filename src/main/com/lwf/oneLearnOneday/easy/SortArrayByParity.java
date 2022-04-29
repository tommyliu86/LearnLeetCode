package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-28 09:55
 */
public class SortArrayByParity {
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if ((nums[left] & 1) != 0 && (nums[right] & 1) != 1) {

                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                } else {
                    while (left < nums.length && (nums[left] & 1) == 0) {
                        left++;

                    }
                    while (right >= 0 && (nums[right] & 1) == 1) {
                        right--;

                    }
                }

            }
            return nums;
        }
    }
}
