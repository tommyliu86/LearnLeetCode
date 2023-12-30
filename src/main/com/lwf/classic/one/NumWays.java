package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 10:11
 */
public class NumWays {
    class Solution {
        public int numWays(int n) {
            int mod=1000000007;
            int i1=1,i2=2;
            if (n==1)return i1;
            if (n==2)return i2;
            int i=2;
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
