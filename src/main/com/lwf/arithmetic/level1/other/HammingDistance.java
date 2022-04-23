package com.lwf.arithmetic.level1.other;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-22 15:50
 */
public class HammingDistance {
    class Solution {
        public int hammingDistance(int x, int y) {
            int i = x ^ y;
            int count=0;
            while (i!=0){
                count+=i&1;
                i=i>>1;
            }
            return count;
        }
    }
}
