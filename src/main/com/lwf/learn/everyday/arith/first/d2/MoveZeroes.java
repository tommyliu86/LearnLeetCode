package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 14:49
 */
public class MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int l=0;
            int r=0;
            while (r<nums.length){
                if (nums[r]!=0){
                    nums[l++]=nums[r++];
                }else{
                    r++;
                }
            }
            while (l<nums.length){
                nums[l++]=0;
            }
        }
    }
}
