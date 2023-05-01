package com.lwf.offer.two.tow;

public class MaximalRectangle {
    class Solution {
        public int maximalRectangle(String[] matrix) {
            int[][][] lens=new int[matrix.length][matrix[0].length()][2];
            for (int i = 0; i < lens.length; i++) {
                for (int j = 0; j < lens[i].length; j++) {
                    if (matrix[i].charAt(j)=='1') {
                        lens[i][j][0]=lens[i][j-1][0]+1;
                        lens[i][j][1]=lens[i-1][j][1]+1;
                    }
                }
            }
        }
    }
}
