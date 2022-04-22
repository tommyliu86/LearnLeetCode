package com.lwf.level1.other;

/**
 * Created with IntelliJ IDEA.
 * & 位与，^位异或 |位或。
 * @author: liuwenfei14
 * @date: 2022-04-22 15:53
 */
public class ReverseBits {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;

        System.out.println(n & 1);
        for (int i = 0; i < 32; i++) {
            n = n >> 1;
            System.out.println(n);
        }
    }

    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int rtn = 0;
            int i=0;
            while (i<32&&n!=0){
               rtn=(rtn<<1)+(n&1);
                n>>=1;
                i++;
            }
            while (i<32){
                rtn<<=1;
                i++;
            }
            return rtn;
        }
    }
}
