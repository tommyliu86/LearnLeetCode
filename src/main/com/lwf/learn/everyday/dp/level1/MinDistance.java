package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 * 字符串的子序列、字符串的编辑等问题，都是二维dp的解法！
 * @author: liuwenfei14
 * @date: 2022-05-21 18:47
 */
public class MinDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] mark=new int[word1.length()+1][word2.length()+1];
            for (int i = 0; i < mark.length; i++) {
                mark[i][0]=i;
            }
            for (int i = 0; i < mark[0].length; i++) {
                mark[0][i]=i;
            }
            for (int i = 1; i < mark.length; i++) {
                for (int j = 1; j < mark[0].length; j++) {
                    if (word1.charAt(i-1)==word2.charAt(j-1)){

                        mark[i][j]=Math.min( mark[i-1][j-1],Math.min(mark[i-1][j]+1,mark[i][j-1]+1));
                    }else{
                        mark[i][j]=Math.min( mark[i-1][j-1]+1,Math.min(mark[i-1][j]+1,mark[i][j-1]+1));
                    }
                }
            }
            int maxL = mark[word1.length()][word2.length()];
            return maxL;

        }
    }
}
