package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-03 09:58
 */
public class LongestPalindrome {
    class Solution {
        public int longestPalindrome(String s) {
            int[] ints=new int[26*2];
            int l=0;
            for (int i = 0; i < s.length(); i++) {
                int j = s.charAt(i) - 'A';
                if (ints[j]==1) {
                    l+=2;
                    ints[j]--;
                }else{
                    ints[j]++;
                }
            }
            return l==s.length()?l:l+1;
        }
    }
}
