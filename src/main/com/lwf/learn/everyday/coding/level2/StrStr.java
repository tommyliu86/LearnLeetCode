package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 10:16
 */
public class StrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            int i = 0;
            while (i + needle.length() < haystack.length()) {
                int left = i;
                int j = 0;
                while (j < needle.length() && haystack.charAt(left) == needle.charAt(j)) {
                    left++;
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
            return 0;
        }
    }
}
