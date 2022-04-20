package com.lwf.level1.number;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-19 18:11
 */
public class IsPowerOfThree {
    class Solution {
        public boolean isPowerOfThree(int n) {
            while (n%3==0){
                n/=3;
            }
            return n==0;
        }
    }
}
