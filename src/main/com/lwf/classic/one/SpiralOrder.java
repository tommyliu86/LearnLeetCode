package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/2/8 11:08
 */
public  class SpiralOrder {

    /**
     * 模拟 顺时针线路，注意特殊判断的两个条件，
     */
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length==0) return new int[0];
            int x=matrix.length;
            int y=matrix[0].length;
            int[] ans=new int[x*y];
            int ii=0;
            for (int c = 0;ii<ans.length&& c < x / 2 + (x % 2); c++) {
                int minx=c,maxx=x-1-c,miny=c,maxy=y-1-c;
                int i=c;
                int j=c;
                if (i==maxx&&j==maxy) {
                    ans[ii++]=matrix[i][j];
                    continue;
                }
                while (i<maxx||j<maxy){
                    ans[ii++]=matrix[i][j];
                    if (j<maxy){
                        j++;
                    }else{
                        i++;
                    }
                }
                if (minx==maxx||miny==maxy){
                    ans[ii++]=matrix[i][j];
                    continue;
                }
                while (i>minx||j>miny){
                    ans[ii++]=matrix[i][j];
                    if (j>miny){
                        j--;
                    }else{
                        i--;
                    }
                }
            }
            return ans;
        }
    }
}
