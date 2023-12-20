package com.lwf.oneLearnOneday.normal;

/**
 * 1901. 寻找峰值 II
 * @author liuwenfei
 * @date 2023/12/19 9:11
 */
public class FindPeakGrid {
    /**
     * 仍然是二分查找，只是这里面需要考虑如何二分，考虑每行上的最大值，那么可以考虑根据这个最大值进行上下行的二分。找到峰值的行，然后找到该行的最大值即可！
     * 二分查找的方法，与一维数组的寻找峰值一样。
     */
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int i=0,j=mat.length-1;
            while (i<j){
                int m=i+(j-i)/2;
                int y = findMax(mat[m]);
                if (mat[m][y]>mat[m+1][y]){
                    j=m;
                }else{
                    i=m+1;
                }
            }
            return new int[]{i,findMax(mat[i])};
        }
        public int findMax(int[] ints){
            int i=0;
            for (int i1 = 1; i1 < ints.length; i1++) {
                if (ints[i1]>ints[i]){
                    i=i1;
                }
            }
            return i;
        }
    }
}
