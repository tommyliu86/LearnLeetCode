package com.lwf.arithmetic.level2.sort;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * 快速排序重新学习
 * @author: liuwenfei14
 * @date: 2022-05-05 11:56
 */
public class FindKthLargest {
    class Solution {
        Random rand = new Random(); //快速排序需要使用random，不然速度会降低一个数量级。

        public int findKthLargest(int[] nums, int k) {

            return fast(nums, 0, nums.length - 1, k-1);

        }

        /**
         * 快速排序的应用，寻找第k个数。因此不需要全部排序，只需要排序一部分即可。
         * @param nums
         * @param left
         * @param right
         * @param k
         * @return
         */
        public int fast(int[] nums, int left, int right, int k) {
            if (left >= right) {
                return nums[left];
            }
            //基准数选择后，需要把index的值和left进行初始化，不然会少一个值。
            int index = rand.nextInt(right - left + 1) + left;
            int x = nums[index];
            nums[index] = nums[left];
            int ol = left;
            int or = right;

            while (left < right) {
                while (nums[right] <= x && right > left) {
                    right--;
                }

                nums[left] = nums[right];
                while (nums[left] >= x && left < right) {
                    left++;
                }
                nums[right] = nums[left];

            }
            nums[left] = x;
            if (left == k) {
                return nums[left];
            }
            if (left < k) {
                return fast(nums, left + 1, or, k);
            } else {
                return fast(nums, ol, left - 1, k);
            }
        }
    }
}
