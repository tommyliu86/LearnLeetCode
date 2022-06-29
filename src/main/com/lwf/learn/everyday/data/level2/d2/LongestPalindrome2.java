package com.lwf.learn.everyday.data.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-29 14:16
 */
public class LongestPalindrome2 {
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] pa = new boolean[n][n];
            for (int i = 0; i < pa.length; i++) {
                pa[i][i] = true;
            }
            int len = 1;
            int l=0;
            int r=0;
            for (int i = 2; i < n; i++) {
                for (int j = 0; j+i < n; j++) {
                    if (s.charAt(j)==s.charAt(j+i-1)){
                        pa[j][j+i-1]=(j+1>j+i-2)||pa[j+1][j+i-2];
                    }
                    if (len<i&& pa[j][j+i-1]){
                        len=i;
                        l=j;
                        r=j+i-1;
                    }
                }
            }
            return s.substring(l,r+1);
        }
    }
}
