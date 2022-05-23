package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-21 10:55
 */
public class LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] mark=new int[text1.length()+1][text2.length()+1];
            for (int i = 1; i < mark.length; i++) {
                for (int j = 1; j < mark[0].length; j++) {
                    if (text1.charAt(i-1)==text2.charAt(j-1)){
                        mark[i][j]=mark[i-1][j-1]+1;
                    }else{
                        mark[i][j]=Math.max(mark[i-1][j],mark[i][j-1]);
                    }
                }
            }
            return mark[text1.length()][text2.length()];
        }
    }

}
