package com.lwf.learn.everyday.coding.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 15:47
 */
public class StrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack.length()<needle.length()){
                return -1;
            }
            int l=0;
            while (l+needle.length()<=haystack.length()){

                int i=0;
                while (i<needle.length()&&haystack.charAt(i+l)==needle.charAt(i)){
                    i++;
                }
                if (i==needle.length()) {
                    return l;
                }
                l++;
            }
            return -1;
        }
    }
}
