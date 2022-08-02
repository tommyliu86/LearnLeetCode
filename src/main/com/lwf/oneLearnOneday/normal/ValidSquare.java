package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

public class ValidSquare {
    /**
     * 向量计算，如何判断向量垂直和向量平行！！
     */

   class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            int[][] ints=new int[4][2];
            ints[0]=p1;
            ints[1]=p2;
            ints[2]=p3;
            ints[3]=p4;
            Arrays.sort(ints,(a,b)-> {
                if (a[0]==b[0]){
                    return Integer.compare (a[1], b[1]);
                }else{
                    return Integer.compare(a[0],b[0]);
                }
            });
            if (ints[3][0]==ints[0][0]&&ints[3][1]==ints[0][1]){
                return false;
            }
            if ((ints[3][0]+ints[0][0])!=(ints[2][0]+ints[1][0])||(ints[3][1]+ints[0][1])!=(ints[2][1]+ints[1][1])){
                return false;
            }else{

                int x1 = ints[0][0] - ints[3][0];
                int y1 = ints[0][1] - ints[3][1];
                int x2 = ints[1][0] - ints[2][0];
                int y2 = ints[1][1] - ints[2][1];
                return y1 * x2 + y2 * x1 ==0
                        &&((x1*x1+y1*y1)==(x2*x2+y2*y2));
            }
        }
    }
}
