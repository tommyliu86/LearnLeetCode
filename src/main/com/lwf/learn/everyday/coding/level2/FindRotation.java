package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-19 18:00
 */
public class FindRotation {
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            int n = mat.length;
            boolean same=false;
            for (int k = 0;!same&& k < 4; k++) {
                boolean subSame=true;
                for (int i = 0; subSame&& i < mat.length; i++) {
                    for (int j = 0; j < mat.length; j++) {
                        if (mat[i][j]!=target[i][j]) {
                            subSame=false;
                            break;
                        }
                    }
                }
                if (!same){
                    for (int i = 0; i < mat.length; i++) {
                        for (int j = i; j + i < mat.length - 1; j++) {
                            int x = j;
                            int y = n - i - 1;
                            int num = mat[i][j];
                            while (x != i || y != j) {
                                int temp = mat[x][y];
                                mat[x][y] = num;
                                num = temp;

                                int tempx=x;
                                x=y;
                                y=n-tempx-1;
                            }
                            mat[x][y] = num;
                        }
                    }
                }
                same=subSame;
            }
            return same;
        }
    }
}
