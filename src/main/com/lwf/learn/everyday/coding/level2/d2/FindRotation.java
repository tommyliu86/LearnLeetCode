package com.lwf.learn.everyday.coding.level2.d2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-19 18:57
 */
public class FindRotation {
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            for (int i = 0; i < 4; i++) {
                if (equal(mat,target)) {
                    return true;
                }
                mat=rotate(mat);
            }
            return false;
        }
        public boolean equal(int[][] mat,int[][] t){
            for (int i = 0; i < mat.length; i++) {
                if (!Arrays.equals(mat[i],t[i])){
                    return false;
                }
            }
            return true;
        }
        public int[][] rotate(int[][] mat){
            for (int i = 0; i < mat.length/2; i++) {
                for (int j = i; j < mat[i].length-1-i; j++) {

                    int newx=j;
                    int newy=mat.length-1-i;
                    int pre=mat[i][j];
                    while (newx!=i||newy!=j){
                        int temp=mat[newx][newy];
                        mat[newx][newy]=pre;
                        pre=temp;

                        int t=newx;
                        newx=newy;
                        newy=mat.length-1-t;
                    }
                    mat[i][j]=pre;
                }
            }
            return mat;

        }
    }
}
