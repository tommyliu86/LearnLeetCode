package com.lwf.arithmetic.level1.other;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-22 15:31
 */
public class HammingWeight {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count += n & 1;
                n = n >> 1;
            }
            return count;
        }
        public int hammingWeight1(int n) {
            int count = 0;
            while (n != 0) {
                n=(n&(n-1));
                count++;
            }
            return count;
        }
        public int hammingWeight2(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                count += n & 1;
                n = n >> 1;
            }

            return count;
        }
    }
}
