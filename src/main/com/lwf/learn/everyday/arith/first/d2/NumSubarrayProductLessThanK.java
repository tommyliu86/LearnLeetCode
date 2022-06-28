package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-27 14:11
 */
public class NumSubarrayProductLessThanK {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int num=0;
            int l=0;
            int r=0;
            long multi=1;
            while (r<nums.length){
                multi*=nums[r++];
                while (l<r&& multi>=k){
                    multi/=nums[l++];
                }
                num+=r-l;


            }
            return num;
        }
    }
}
