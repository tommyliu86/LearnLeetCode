package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-27 19:53
 */
public class SpiralOrder {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> rtn = new ArrayList<>();
            int xl = matrix.length;
            int yl=matrix[0].length;
            int i=0;
            while (rtn.size()<xl*yl&& i<((xl&1)==1?xl/2+1:xl/2)){
                int minx=i;
                int maxx=xl-1-i;
                int miny=i;
                int maxy=yl-1-i;
                //对于m，n 不相等的矩阵，没有办法直接循环，因此需要分别行列进行计算
                for (int j = miny; j <= maxy; j++) {
                    rtn.add(matrix[minx][j]);
                }
                for (int k = minx+1; i < maxx; i++) {
                    rtn.add(matrix[k][maxy]);
                }
                if (minx<maxx&&miny<maxy){
                    for (int j = maxy-1; j >= miny; j--) {
                        rtn.add(matrix[maxx][j]);
                    }
                    for (int k = maxx-1; i > minx; i--) {
                        rtn.add(matrix[k][miny]);
                    }
                }
                i++;
            }
            return rtn;
        }
    }
}
