package com.lwf.learn.everyday.arith.first.day13;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-12 10:18
 */
public class HammingWeight {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count=0;
            while (n!=0){
                n=n&(n-1);
                count++;
            }
            return count;
        }
    }
}
