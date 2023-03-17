package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/3/17 16:47
 */
public class IsAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.equals(t)||s.length()!=t.length()) return false;
            int[] marks=new int[26];
            for (int i = 0; i < s.length(); i++) {
                marks[s.charAt(i)-'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                marks[t.charAt(i)-'a']--;
            }
            for (int i = 0; i < marks.length; i++) {
                if (marks[i]!=0) {
                    return false;
                }
            }
            return true;
        }
    }
}
