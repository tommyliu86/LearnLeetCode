package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-23 17:52
 */
public class Fib {
    class Solution {
        public int fib(int n) {
            if (n<2){
                return n;
            }
            int pre=0;
            int cur=1;
            int i=1;
            while (i<n){
                i++;
                int temp=cur;
                cur=cur+pre;
                pre=temp;
            }
            return cur;
        }
    }
}
