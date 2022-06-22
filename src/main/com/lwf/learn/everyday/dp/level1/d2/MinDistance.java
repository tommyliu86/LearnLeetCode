package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-10 23:10
 */
public class MinDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] lens=new int[word1.length()+1][word2.length()+1];
            for (int i = 0; i < lens.length; i++) {
                lens[i][0]=i;
            }
            for (int i = 0; i < lens[0].length; i++) {
                lens[0][i]=i;
            }
            for (int i = 1; i < lens.length; i++) {
                for (int j = 1; j < lens[i].length; j++) {
                    if (word1.charAt(i-1)==word2.charAt(j-1)){

                        lens[i][j]=Math.min(lens[i-1][j-1],Math.min(lens[i-1][j]+1,lens[i][j-1]+1));
                    }else{
                        lens[i][j]=Math.min(lens[i-1][j-1]+1,Math.min(lens[i-1][j]+1,lens[i][j-1]+1));
                    }
                }
            }
            return lens[word1.length()][word2.length()];
        }
    }
}
