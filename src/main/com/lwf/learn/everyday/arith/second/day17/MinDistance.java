package com.lwf.learn.everyday.arith.second.day17;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-29 15:18
 */
public class MinDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            char[] y = word1.toCharArray();
            char[] x = word2.toCharArray();
            int[][] length=new int[x.length+1][y.length+1];
            for (int i = 0; i < length.length; i++) {
                for (int j = 0; j < length[i].length; j++) {
                    if (x[i]==y[j]) {
                        length[i][j]=length[i-1][j-1]+1;
                    }else{
                        length[i][j]=Math.max(length[i][j-1],length[i-1][j]);
                    }
                }
            }
            return x.length+y.length -2*length[x.length][y.length];
        }
    }
}
