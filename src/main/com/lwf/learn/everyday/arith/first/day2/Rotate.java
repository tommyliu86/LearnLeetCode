package com.lwf.learn.everyday.arith.first.day2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-01 14:53
 */
public class Rotate {
    /**
     * 双指针 原地交换，使用count记录遍历过的数组元素个数。
     */
    class test {
        public void rotate(int[] nums, int k) {
            int step = k % nums.length;
            int count = 0;
            for (int i = 0; i < step && count <= nums.length; i++) {

                int right = (i + step) % nums.length;
                int leftNum = nums[i];
                while (right != i) {
                    int temp = nums[right];
                    nums[right] = leftNum;
                    leftNum = temp;

                    right = (right + step) % nums.length;
                    count++;
                }
                nums[i] = leftNum;
                count++;
            }
        }
    }

    /**
     * 模拟，直接计算移动后的位置。使用辅助数组保存移位后的数
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            if ((nums.length < 2) || k == 0) {
                return;
            }

            int[] rtn = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                rtn[(i + k) % nums.length] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = rtn[i];
            }

        }
    }
}
