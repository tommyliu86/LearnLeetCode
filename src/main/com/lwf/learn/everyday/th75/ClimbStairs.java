package com.lwf.learn.everyday.th75;

public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n<3){
                return n;
            }
            int pre=1;
            int cur=2;
            int i=2;
            while (i<n){
                int temp=cur;
                cur+=pre;
                pre=temp;
                i++;
            }
            return cur;
        }
    }
}
