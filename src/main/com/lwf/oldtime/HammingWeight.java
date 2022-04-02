package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-07-24
 */
public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
