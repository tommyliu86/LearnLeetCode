package com.lwf.arithmetic.level1.chars;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-11 18:47
 */
public class StrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack.length() < needle.length()) {
                return -1;
            }
            char[] achars = haystack.toCharArray();
            char[] bchars = needle.toCharArray();

            for (int i = 0; i < achars.length - bchars.length + 1; i++) {
                int a = i;
                int b = 0;
                while (b < bchars.length && achars[a] == bchars[b]) {
                    a++;
                    b++;
                }
                if (b==bchars.length){
                    return i;
                }
            }
            return -1;
        }
    }
}
