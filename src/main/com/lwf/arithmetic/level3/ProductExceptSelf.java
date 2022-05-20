package com.lwf.arithmetic.level3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-19 20:01
 */
public class ProductExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] rtn = new int[nums.length];
            rtn[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                rtn[i] = rtn[i - 1] * nums[i - 1];
            }
            int multi = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                multi *= nums[i + 1];
                rtn[i] *= multi;
            }
            return rtn;
        }
    }
}
