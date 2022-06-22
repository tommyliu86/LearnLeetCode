package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-10 18:30
 */
public class LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] lens=new int[text1.length()+1][text2.length()+1];
            for (int i = 1; i < lens.length; i++) {
                char c = text1.charAt(i - 1);
                for (int j = 1; j < lens[i].length; j++) {
                    char c1 = text2.charAt(j - 1);
                    if (c==c1){
                        lens[i][j]=lens[i-1][j-1]+1;
                    }else{
                        lens[i][j]=Math.max(lens[i-1][j],lens[i][j-1]);
                    }
                }
            }
            return lens[text1.length()][text2.length()];
        }
    }
}
