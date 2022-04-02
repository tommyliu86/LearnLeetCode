package com.lwf.learn.everyday.first.day2;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/squares-of-a-sorted-array/submissions/
 * 977. 有序数组的平方
 * @author: liuwenfei14
 * @date: 2022-04-01 14:27
 */
public class SortedSquares {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            if (nums[0]>=0){
                for (int i = 0; i < nums.length; i++) {
                    nums[i]=nums[i]*nums[i];
                }
                return nums;
            }else{
                int left=0;
                int right=nums.length-1;
                int[] rtn=new int[nums.length];
                int index=nums.length-1;
                while (left<right){
                    if (Math.abs(nums[left])>Math.abs(nums[right])){
                        rtn[index]=nums[left]*nums[left];
                        left++;
                    }else{
                        rtn[index]=nums[right]*nums[right];
                        right--;
                    }
                    index--;
                }
                rtn[index]=nums[left]*nums[left];
                return rtn;
            }

        }
    }
}
