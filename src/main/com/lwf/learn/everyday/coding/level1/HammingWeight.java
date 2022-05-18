package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 17:03
 */
public class HammingWeight {
    public static void main(String[] args) {
        new Solution().hammingWeight(-1);
    }
    static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n!=0){
                count+=n&1;
                n>>>=1;
            }
            return count;
        }
    }
}
