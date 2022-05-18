package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode.cn/problems/longest-palindromic-subsequence/submissions/
 * 子字符串的动态规划解法，一般都是用二维数组，进行状态转移！
 * @author: liuwenfei14
 * @date: 2022-05-18 15:39
 */
public class LongestPalindromeSubseq {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] pa=new int[s.length()][s.length()];
            for (int i = 0; i < pa.length; i++) {
                pa[i][i]=1;
            }
            char[] chars = s.toCharArray();
            int max=1;
            for (int L = 2; L <= chars.length; L++) {
                for (int i = 0; i+L <= chars.length; i++) {
                    int j=i+L-1;
                    if (chars[j]==chars[i]){
                        pa[i][j]=pa[i+1][j-1]+2;
                    }else{
                        pa[i][j]=Math.max(pa[i][j-1],pa[i+1][j]);
                    }
                    max=Math.max(max,pa[i][j]);
                }
            }
            return max;
        }
    }
}
