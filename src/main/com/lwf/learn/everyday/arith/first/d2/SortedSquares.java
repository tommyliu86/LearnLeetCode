package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 13:51
 */
public class SortedSquares {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] rtn=new int[nums.length];
            if (nums[0]>=0){
                for (int i = 0; i < nums.length; i++) {
                    rtn[i]=nums[i]*nums[i];
                }
            }else{
                int l=0;
                int r=nums.length-1;
                int i=nums.length-1;
                while (l<r){
                    if (nums[l]*nums[l]<nums[r]*nums[r]){
                        rtn[i--]=nums[r]*nums[r];
                        r--;
                    }else{
                        rtn[i--]=nums[l]*nums[l];
                        l++;
                    }
                    rtn[0]=nums[l]*nums[l];
                }
            }
            return rtn;
        }
    }
}
