package com.lwf.learn.everyday.coding;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-08 15:11
 */
public class MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int left=0;
            int right=0;
            while (right<nums.length){
                if (nums[right]!=0&&left!=right){
                   int temp= nums[left];
                   nums[left]=nums[right];
                   nums[right]=temp;
                   left++;

                }
                right++;
            }
        }
    }
}
