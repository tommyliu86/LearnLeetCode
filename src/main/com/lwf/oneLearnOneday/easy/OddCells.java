package com.lwf.oneLearnOneday.easy;


public class OddCells {
    /**
     * 按照行列单独计算，然后根据奇数+奇数=偶数 来进行计算行列重合的位置的情况
     */
    class Solution {
        public int oddCells(int m, int n, int[][] indices) {
            int[] rows = new int[m];
            int[] columns = new int[n];
            for (int i = 0; i < indices.length; i++) {
                int[] index = indices[i];
                rows[index[0]]++;
                columns[index[1]]++;
            }
            int count = 0;
            for (int i = 0; i < columns.length; i++) {
                if ((columns[i]&1)==1){
                    count++;
                }
            }
            int rtn=0;
            for (int i = 0; i < rows.length; i++) {
                int sub=Math.abs((rows[i]&1)*n-count);
                rtn+=sub;
            }
            return rtn;

        }
    }
}
