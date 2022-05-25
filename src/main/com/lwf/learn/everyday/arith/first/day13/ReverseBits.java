package com.lwf.learn.everyday.arith.first.day13;

/**
 * Created with IntelliJ IDEA.
 * 位运算的优先级不是最高的，与普通计算一致，因此需要注意用括号。
 * @author: liuwenfei14
 * @date: 2022-04-13 10:23
 */
public class ReverseBits {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int rtn=0;
            int index=0;
            while ((index<32)&&n!=0){
                int i = n & 1;
                rtn=(rtn<<1)+i;
                n=n>>1;
                index++;
            }
            while (index<32){
                rtn=rtn<<1;
                index++;
            }
            return rtn;
        }
    }

}
