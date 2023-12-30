package com.lwf.classic.two.tow;

/**
 * @author liuwenfei
 * @date 2023/4/15 11:32
 */
public class IsAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length()||s.equals(t)){
                return false;
            }
            int[] marks=new int[26];
            for (int i = 0; i < s.length(); i++) {
                marks[s.charAt(i)-'a']++;
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
