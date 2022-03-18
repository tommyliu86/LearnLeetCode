package com.lwf.TOP100.normal;

import java.rmi.MarshalException;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-11-28 Time: 09:28
 */
public class MaximalSquare {
    /**
     * 暴力遍历法
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix==null||matrix.length==0) return max;
        int x = matrix.length;
        int y = matrix[0].length;
        for (int i = 0; i < x && x - i > max; i++) {
            for (int j = 0; j < y && y - j > max; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, getSqua(matrix, i, j, x, y));
                }
            }
        }
        return max;
    }

    int getSqua(char[][] matrix, int i, int j, int x, int y) {
        int len = 0;
        boolean getMax = false;
        while (i + len < x && j + len < y && !getMax) {
            for (int k = 0; k < len + 1; k++) {
                if (matrix[i + len][j + k] != '1' || matrix[i + k][j + len] != '1') {
                    getMax = true;
                    break;
                }
            }
           if (!getMax){
               len++;
           }
        }
        return len;
    }

    public static void main(String[] args) {
        char[][] chars=new char[1][1];
        chars[0]=new char[]{'1'};
        new MaximalSquare().dynamicProgram(chars);
    }

    /**
     * 动态规划方法
     * @param matrix
     * @return
     */
    public int dynamicProgram(char[][] matrix) {
        int max=0;
        if (matrix==null||matrix.length==0) return max;
        int x=matrix.length;
        int y=matrix[0].length;
        int[] lens=new int[y];
        for (int i = 0; i < x; i++) {
            int temp=0;
            for (int j = 0; j < y; j++) {
                if (matrix[i][j]=='1'){
                    int intemp=lens[j];
                    lens[j]=1+((i-1<0||j-1<0)?0:Math.min(lens[j-1],Math.min(lens[j],temp)));
                    temp=intemp;
                }
                else {
                    lens[j]=0;
                    temp=lens[j];
                }
                max= Math.max(max,lens[j]);
            }
        }
        return max*max;
    }
}
