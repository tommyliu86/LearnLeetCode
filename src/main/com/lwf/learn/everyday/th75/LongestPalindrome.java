package com.lwf.learn.everyday.th75;

public class LongestPalindrome {
    class Solution {
        public int longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int[] mark=new int[128];
            for (int i = 0; i < chars.length; i++) {
                mark[chars[i]]++;
            }
            int l=0;
            for (int i = 0; i < mark.length; i++) {
              l+=2*(  mark[i]/2);
            }
            return l==s.length()?l : l+1;
        }
    }
}
