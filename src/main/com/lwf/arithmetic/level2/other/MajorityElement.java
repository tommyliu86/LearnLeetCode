package com.lwf.arithmetic.level2.other;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-18 16:41
 */
public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 1;
            int rtn = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    rtn = nums[i];
                    count++;
                } else if (nums[i] == rtn) {
                    count++;
                } else {
                    count--;

                }
            }
            return rtn;
        }
    }
}
