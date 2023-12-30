package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 10:05
 */
public class Fib {
    class Solution {
        public int fib(int n) {
            int mod=1000000007;
            int i1=0,i2=1;
            if (n==0)return i1;
            if (n==1)return i2;
            int i=1;
            while (i<n){
                int i3=(i1+i2)%mod;
                i1=i2;
                i2=i3;
                i++;
            }
            return i2;
        }
    }
}
