package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-08 09:38
 */
public class LongestPalindrome {
    class Solution {
        public String longestPalindrome(String s) {
            boolean[][] isPa=new boolean[s.length()][s.length()];
            for (int i = 0; i < isPa.length; i++) {
                isPa[i][i]=true;
            }
            int step=1;
            char[] chars = s.toCharArray();

            int l=0;
            int r=0;
            while (step<s.length()){
                step++;
                for (int i = 0; i+step-1 < chars.length; i++) {
                    int next=i+step-1;
                    if (chars[i]==chars[next]&&(i+1>=next-1|| isPa[i+1][next-1])){
                        isPa[i][next]=true;
                        l=i;
                        r=next;
                    }
                }
            }
            return s.substring(l,r+1);
        }
    }
}
