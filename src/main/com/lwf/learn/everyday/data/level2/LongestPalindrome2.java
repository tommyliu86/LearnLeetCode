package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-04 11:24
 */
public class LongestPalindrome2 {
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n<2){
                return s;
            }
            boolean[][] pa=new boolean[n][n];

            for (int i = 0; i < pa.length; i++) {
                pa[i][i]=true;
            }
            int left=0;
            int right=0;
            for (int l = 1; l < n; l++) {
                for (int i = 0; i+l < n; i++) {
                    if (s.charAt(i)==s.charAt(i+l)&&(i+1>=i+l-1||pa[i+1][i+l-1])){
                        pa[i][i+l]=true;
                        left=i;
                        right=i+l;
                    }
                }
            }
            return s.substring(left,right+1);

        }
    }
}
