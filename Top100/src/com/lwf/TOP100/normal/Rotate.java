package com.lwf.TOP100.normal;

/**
 * author Administrator
 * time 2019-10-10-23:15
 * {@link md/normal/48.md}
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < matrix.length / 2; i++) {

            for (int j = i; j <n-1-i; j++) {
                int temp=matrix[i][j];
                int x=i;
                int y=j;
                for (int k = 0; k < 4; k++) {
                    int x1= y;
                    int  y1=n-1-x;
                   temp=  matrix[x1][y1]^temp;
                   matrix[x1][y1]=temp^matrix[x1][y1];
                   temp=matrix[x1][y1]^temp;
                   x=x1;
                   y=y1;
                }
            }
        }
    }
}
