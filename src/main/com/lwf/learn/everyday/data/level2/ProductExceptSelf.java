package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 17:59
 */
public class ProductExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] multi=new int[nums.length];
            multi[0]=1;
            for (int i = 1; i < nums.length; i++) {
                multi[i]=multi[i-1]*nums[i-1];
            }
            int m=1;
            for (int i = multi.length - 2; i >= 0; i--) {
                m=m*nums[i+1];
                multi[i]=multi[i]*m;
            }
            return multi;
        }
    }
}
