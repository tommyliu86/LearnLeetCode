package com.lwf.learn.everyday.data.level2.d2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 17:39
 */
public class ProductExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] rtn=new int[nums.length];
            Arrays.fill(rtn,1);
            for (int i = 1; i < rtn.length; i++) {
                rtn[i]=rtn[i-1]*nums[i-1];
            }
            int post=1;
            for (int i = rtn.length - 2; i >= 0; i--) {
                post=post*nums[i+1];
                rtn[i]=rtn[i]*post;
            }
            return rtn;
        }
    }
}
