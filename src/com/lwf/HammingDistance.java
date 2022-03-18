package com.lwf;

/**
 * author Administrator
 * time 2019-08-17-0:42
 * {@link 461.md}
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(  x^y);
    }
    public int hammingDistance1(int x, int y) {
        int z=x^y;
        int count=0;
        while (z!=0){
            z=z&(z-1);
            count++;
        }
        return count;

    }
}
