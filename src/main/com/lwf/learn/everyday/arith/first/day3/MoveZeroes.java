package com.lwf.learn.everyday.arith.first.day3;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/move-zeroes/
 * 283. 移动零
 * @author: liuwenfei14
 * @date: 2022-04-02 10:59
 */
public class MoveZeroes {
    class Solution {
        /**
         * 双指针，left指针指向的是要插入的位置，right指针向后遍历，如果是0则不需要处理，如果是数字，则插入到left
         * 最后所有的0都会移动到末尾
         *
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            int left=0;
            int right=0;
            while (right<nums.length){
                if (nums[right]==0){
                    right++;
                }else {
                    int temp=nums[left];
                    nums[left++]=nums[right];
                    nums[right]=temp;
                    right++;
                }
            }

        }
    }
}
