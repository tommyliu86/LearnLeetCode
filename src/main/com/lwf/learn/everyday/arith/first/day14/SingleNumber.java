package com.lwf.learn.everyday.arith.first.day14;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-13 11:00
 */
public class SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int rtn=0;
            for (int i = 0; i < nums.length; i++) {
                rtn^=nums[i];
            }
            return rtn;
        }
    }
}
