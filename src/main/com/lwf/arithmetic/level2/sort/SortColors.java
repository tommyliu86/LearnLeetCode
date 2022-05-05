package com.lwf.arithmetic.level2.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-05 10:11
 */
public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int i = 0;
            while (i <= right) {
                if (nums[i] == 0) {
                    if (i != left) {
                        int temp = nums[left];
                        nums[left] = nums[i];
                        nums[i] = temp;
                        left++;
                    } else {
                        left++;
                        i++;
                    }
                } else if (nums[i] == 2) {
                    int temp = nums[right];
                    nums[right] = nums[i];
                    nums[i] = temp;
                    right--;
                } else {
                    i++;
                }
            }
        }
    }
}
