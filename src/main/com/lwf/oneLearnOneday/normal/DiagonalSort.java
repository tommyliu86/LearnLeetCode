package com.lwf.oneLearnOneday.normal;

/**
 * 1329. 将矩阵按对角线排序
 *
 * @author: liuwenfei
 * @date: 2024/4/29-8:21
 */
public class DiagonalSort {
    /**
     * 插入排序
     */
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            if (mat.length==1||mat[0].length==1){
                return mat;
            }
            for (int i = 0; i < mat.length; i++) {
                int j=i+1,k=1;
                while (j<mat.length&&k<mat[0].length){
                    int cur=mat[j][k];
                    int l=1;
                    while (j-l>=0&&k-l>=0&& cur<mat[j-l][k-l]){
                        mat[j-l+1][k-l+1]=mat[j-l][k-l];
                        l++;
                    }
                    mat[j-l+1][k-l+1]=cur;
                    j++;
                    k++;
                }
            }
            for (int i = 1; i < mat[0].length; i++) {
                int j=1,k=i+1;
                while (j<mat.length&&k<mat[0].length){
                    int cur=mat[j][k];
                    int l=1;
                    while (j-l>=0&&k-l>=0&& cur<mat[j-l][k-l]){
                        mat[j-l+1][k-l+1]=mat[j-l][k-l];
                        l++;
                    }
                    mat[j-l+1][k-l+1]=cur;
                    j++;
                    k++;
                }
            }
            return mat;
        }
    }
}
