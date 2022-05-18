package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 14:35
 */
public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }

        public int climbStairs1(int n) {
            if (n < 3) {
                return n;
            }
            int pre = 1;
            int cur = 2;
            int i=3;
            while (i<=n){
                int temp=cur;
                cur+=pre;
                pre=temp;
                i++;
            }
            return cur;
        }

    }
}
