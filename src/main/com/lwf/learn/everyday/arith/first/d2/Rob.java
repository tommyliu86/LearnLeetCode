package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-24 14:16
 */
public class Rob {
    class Solution {
        public int rob(int[] nums) {
            int get=nums[0];
            int unget=0;
            int i=1;
            while (i<nums.length){
                int preget=get;
                get=Math.max(unget+ nums[i],preget);
                unget=Math.max(preget,unget);
                i++;
            }
            return Math.max(unget,get);
        }
    }
}
