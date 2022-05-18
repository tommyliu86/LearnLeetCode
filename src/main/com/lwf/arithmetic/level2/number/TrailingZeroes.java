package com.lwf.arithmetic.level2.number;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 16:54
 */
public class TrailingZeroes {
    class Solution {
        public int trailingZeroes(int n) {
            int r=0;
            while (n>0){
                r+=n/5;
                n=n/5;
            }
            return r;
        }
    }
}
