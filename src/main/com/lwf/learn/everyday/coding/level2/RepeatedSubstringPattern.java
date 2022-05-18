package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-15 21:10
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        new Solution().repeatedSubstringPattern("abacababacab");
    }

    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            char[] chars = s.toCharArray();
            int l = 0;
            int r = 1;
            while (r < chars.length) {
                int i=r;
                while (i < chars.length && chars[i] == chars[l]) {
                    i++;
                    l++;
                }
                if (i== chars.length) {
                    return chars.length % (i - l) == 0;
                } else {
                        l=0;
                        r++;


                }
            }
            return false;
        }
    }
}
