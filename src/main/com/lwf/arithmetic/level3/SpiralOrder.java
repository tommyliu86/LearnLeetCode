package com.lwf.arithmetic.level3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-20 09:04
 */
public class SpiralOrder {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> rtn=new ArrayList<>();
            int x=0;

            int xl = matrix.length;
            int yl = matrix[0].length;

            while (x<(xl/2-1+ (xl&1)==1?1:0)){
                int i=x;
                int j=x;
                while (j<yl-x){
                    rtn.add(matrix[i][j]);
                    j++;
                }
                j--;
                while (i<xl-x){
                    rtn.add(matrix[i][j]);
                    i++;
                }
                i--;
                while (j>=x){
                    rtn.add(matrix[i][j]);
                    j--;
                }
                j++;
                while (i>x){
                    rtn.add(matrix[i][j]);
                    i--;
                }
                x++;
            }
            return rtn;
        }
    }
}
