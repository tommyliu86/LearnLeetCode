package com.lwf.learn.everyday.coding.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-19 18:26
 */
public class Rotate {
    class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length/2; i++) {
                for (int j = i; j < matrix[i].length-1-i; j++) {
                    int newx=j;
                    int newy=matrix.length-1-i;
                    int pre=matrix[i][j];
                    while (newx!=i||newy!=j){
                       int temp= matrix[newx][newy];
                       matrix[newx][newy]=pre;
                       pre=temp;
                       int tx=newx;
                       newx=newy;
                       newy=matrix.length-1-tx;
                    }
                    matrix[i][j]=pre;
                }
            }
        }
    }
}
