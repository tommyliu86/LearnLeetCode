package com.lwf.learn.everyday.arith.first.day12;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-11 08:52
 */
public class ClimbStairs {
    /**
     * 递推法。双指针向后
     */
    class test {
        public int climbStairs(int n) {
            if (n<3){
                return n;
            }
            int pre=1;
            int cur=2;
            int index=3;
            while (index++<=n){
                int temp=cur;
                cur+=pre;
                pre=temp;
            }
            return cur;
        }
    }
    /**
     * 递归，会超时
     */
    class Solution {
        public int climbStairs(int n) {
            return getStep(n);
        }
        public int getStep(int n){
            if (n<3){
                return n;
            }

            return getStep(n-1)+getStep(n-2);
        }
    }
}
