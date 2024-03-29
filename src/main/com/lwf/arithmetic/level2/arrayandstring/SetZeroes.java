package com.lwf.arithmetic.level2.arrayandstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-23 19:41
 */
public class SetZeroes {
    /**
     * 使用矩阵的首行首列作为存储，同时使用额外的标记来记录首行首列是否包含0，这样就可以当做是常数空间了。。；
     */
    class test {
        public void setZeroes(int[][] matrix) {
           boolean x=false;
           boolean y=false;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0]==0) {
                    y=true;
                    break;
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i]==0){
                    x=true;
                    break;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j]==0) {
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }
                }
            }

            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i]==0){
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][i]=0;

                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0]==0){
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j]=0;

                    }
                }
            }
            if (x==true){

                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i]=0;

                }
            }
            if (y==true){

                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0]=0;

                }
            }
        }

    }
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> xs=new HashSet<>();
            Set<Integer> ys=new HashSet<>();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j]==0){
                        xs.add(i);
                        ys.add(j);
                    }
                }
            }
            for (Integer x : xs) {
                int[] matrix1 = matrix[x];
                for (int i = 0; i < matrix1.length; i++) {
                    matrix1[i]=0;
                }
            }
            for (Integer y : ys) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][y]=0;
                }
            }

        }
    }
}
