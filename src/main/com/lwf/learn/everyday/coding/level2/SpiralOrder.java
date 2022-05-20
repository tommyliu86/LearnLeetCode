package com.lwf.learn.everyday.coding.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-20 10:33
 */
public class SpiralOrder {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> rtn = new ArrayList<>();
            int x = 0;
            int mx = matrix.length;
            int my = matrix[0].length;
            while (rtn.size()<mx*my&& x < mx / 2 + ((mx & 1) == 1 ? 1 : 0)) {
                int mini = x;
                int minj = x;
                int maxi = mx - x - 1;
                int maxj = my - x - 1;

                for (int  j= minj; j <= maxj; j++) {
                    rtn.add(matrix[mini][j]);
                }
                for (int i = mini+1; i <= maxi; i++) {
                    rtn.add(matrix[i][maxj]);
                }
                if (maxi>mini&&maxj>minj){
                    for (int j = maxj-1; j >= minj; j--) {
                        rtn.add(matrix[maxi][j]);
                    }
                    for (int i = maxi-1; i > mini; i--) {
                        rtn.add(matrix[i][minj]);
                    }

                }
                x++;
            }
            return rtn;
        }
    }
}
