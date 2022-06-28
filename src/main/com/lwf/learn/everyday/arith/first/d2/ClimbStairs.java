package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-24 14:07
 */
public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n<=2){
                return n;
            }
            int pre=1;
            int cur=2;
            int i=2;
            while (i<n){
                int temp=cur;
                cur=pre+cur;
                pre=temp;
                i++;
            }
            return cur;
        }
    }
}
