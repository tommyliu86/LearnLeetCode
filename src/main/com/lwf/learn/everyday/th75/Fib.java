package com.lwf.learn.everyday.th75;

public class Fib {
    class Solution {
        public int fib(int n) {
            int pre=0;
            int cur=1;
            if (n<2){
                return n;
            }
            while (n>0){
                int temp=cur;
                cur+=pre;
                pre=temp;
                n--;
            }
            return cur;
        }
    }
}
