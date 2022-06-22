package com.lwf.learn.everyday.coding.level2.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-20 15:46
 */
public class SpiralOrder {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> rtn=new ArrayList<>();
            int m=matrix.length;
            int n=matrix[0].length;
            for (int i = 0; (rtn.size()<m*n) && i < m/2 +((m&1)== 1?1:0); i++) {
                int minx=i;
                int maxx=m-1-i;
                int miny=i;
                int maxy=n-1-i;

                int x=minx;
                int y=miny;

                while (y<=maxy){
                    rtn.add(matrix[x][y]);
                    y++;
                }
                while (x<maxx){
                    x++;
                    rtn.add(matrix[x][maxy]);
                }
                if (maxx>minx&&maxy>miny){
                    y=maxy;
                    while (y>miny){
                        y--;
                        rtn.add(matrix[x][y]);
                    }
                    while (x>minx+1){
                        x--;
                        rtn.add(matrix[x][y]);
                    }

                }


            }
            return rtn;
        }
    }
}
