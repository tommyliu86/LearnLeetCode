package com.lwf.oneLearnOneday.easy;

/**
 * author Administrator
 * time 2019-09-17-23:11
 * {@link 461.md}
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int r=x^y;
        return Integer.bitCount(r);
    }
}
