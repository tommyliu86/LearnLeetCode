package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-18 11:46
 */
public class LongestPalindrome {

    class Solution {
        public String longestPalindrome(String s) {
            int[][] pas = new int[s.length()][s.length()];
            for (int i = 0; i < pas.length; i++) {
                pas[i][i] = 1;
            }
            char[] chars = s.toCharArray();
            int max=1;
            int l=0;
            int r=0;
            for (int L = 2; L <= chars.length; L++) { //这里注意遍历的方式，是从子字符串长度开始的。
                for (int i = 0; i+L <= chars.length; i++) {
                    int j=i+L-1;
                    if (chars[j]==chars[i]){
                        pas[i][j]=i+1>=j-1?1:pas[i+1][j-1];
                        if (pas[i][j]==1){
                            if (j-i+1>max){

                                max=j-i+1;
                                l=i;
                                r=j;
                            }
                        }
                    }
                }
            }
            return s.substring(l,r+1);
        }
    }
}
