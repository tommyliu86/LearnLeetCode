package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-08 10:03
 */
public class LongestPalindromeSubseq {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            char[] chars = s.toCharArray();
            int[][] pa=new int[chars.length][chars.length];

            for (int i = 0; i < pa.length; i++) {
                pa[i][i]=1;
            }
            int max=1;
            int step=2;
            while ( step<=s.length()){
                for (int i = 0; i+step-1 < chars.length; i++) {
                    int next=i+step-1;
                    if (chars[i]==chars[next]){
                        pa[i][next]=2+((i+1>next-1)?0: pa[i+1][next-1]);
                    }else{
                        pa[i][next]=Math.max(pa[i+1][next],pa[i][next-1]);
                    }
                    max=Math.max(max,pa[i][next]);
                }
                step++;
            }
            return max;

        }
    }
}
