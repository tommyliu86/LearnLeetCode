package com.lwf.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 17:04
 */
public class MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int left=0;
            int right=0;
            while (right<nums.length){
                if (nums[right]!=0){
                    if (left!=right){
                        int temp=nums[left];
                        nums[left]=nums[right];
                        nums[right]=temp;
                    }
                    left++;
                    right++;
                }else{
                    right++;
                }
            }
        }
    }
}
