package com.lwf.learn.everyday.first.day13;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-12 10:10
 */
public class IsPowerOfTwo {
    /**
     * 2的幂只能是>0的！
     */
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            if (n == 1) return true;


            return (n & (n - 1)) == 0;

        }
    }
}
