package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 10:36
 */
public class Fib {
    class Solution {
        public int fib(int n) {
            if (n<2){
                return n;
            }
            int pre=0;
            int cur=1;
            int i=2;
            while (i<=n){
                int t=cur;
                cur+=pre;
                pre=t;
                i++;
            }
            return cur;
        }
    }
}
