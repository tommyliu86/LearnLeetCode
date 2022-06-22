package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-12 10:52
 */
public class NumSquares {
    class Solution {
        public int numSquares(int n) {
            int[] nums=new int[n+1];
            for (int i = 1; i < nums.length; i++) {
                int num=i;
                for (int j = 1; j*j <= i; j++) {
                    num=Math.min( nums[(i-j*j)]+1,num);
                }
                nums[i]=num;
            }
            return nums[n];
        }
    }
}
